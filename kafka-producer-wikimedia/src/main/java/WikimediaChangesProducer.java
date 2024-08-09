import com.launchdarkly.eventsource.EventSource;
import com.launchdarkly.eventsource.background.BackgroundEventHandler;
import com.launchdarkly.eventsource.background.BackgroundEventSource;
import org.apache.kafka.clients.producer.KafkaProducer;

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
