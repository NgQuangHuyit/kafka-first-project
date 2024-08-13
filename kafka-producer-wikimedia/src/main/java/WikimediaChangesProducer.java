import com.launchdarkly.eventsource.EventSource;
import com.launchdarkly.eventsource.background.BackgroundEventHandler;
import com.launchdarkly.eventsource.background.BackgroundEventSource;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.RoundRobinPartitioner;

import java.net.URI;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class WikimediaChangesProducer {
    public static void main(String[] args) throws InterruptedException {
        String bootstrapServers = "localhost:9092";

        Properties props = new Properties();
        props.put("bootstrap.servers", bootstrapServers);
        props.setProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.setProperty("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        //set safe producer config

        props.setProperty("acks", "all");
        props.put(ProducerConfig.ACKS_CONFIG, "all");
        props.put(ProducerConfig.RETRIES_CONFIG, Integer.toString(Integer.MAX_VALUE));

        props.put(ProducerConfig.BATCH_SIZE_CONFIG, Integer.toString(32*1024));
        props.put(ProducerConfig.LINGER_MS_CONFIG, Integer.toString(10));
        props.put(ProducerConfig.COMPRESSION_TYPE_CONFIG, "gzip");

        props.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, RoundRobinPartitioner.class.getName());



        KafkaProducer<String, String> producer = new KafkaProducer<>(props);

        String topic = "wikimedia-changes";

        BackgroundEventHandler handler = new WikimediaChangesHandler(producer, topic);

        String url = "https://stream.wikimedia.org/v2/stream/recentchange";
        EventSource.Builder builder = new EventSource.Builder(URI.create(url));

        BackgroundEventSource bes = new BackgroundEventSource.Builder(handler, builder).build();
        bes.start();

        TimeUnit.MINUTES.sleep(10);

    }
}
