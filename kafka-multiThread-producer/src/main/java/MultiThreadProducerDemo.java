import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MultiThreadProducerDemo {

    final static Logger logger = LoggerFactory.getLogger(MultiThreadProducerDemo.class.getName());

    public static void main(String[] args) {
        Properties props = getProperties();

        KafkaProducer<String, String> producer = new KafkaProducer<>(props);
        Thread[] dispatchers = new Thread[AppConfig.EVENT_FILES.length];
        logger.info("Starting dispatcher threads...");
        for (int i=0; i<dispatchers.length; i++) {
            dispatchers[i] = new Thread(new Dispatcher(producer, AppConfig.TOPIC, AppConfig.EVENT_FILES[i]));
            dispatchers[i].start();
        }

        try {
            for (Thread thread : dispatchers) {
                thread.join();
            }
        } catch (InterruptedException e) {
            logger.error("Main thread interrupted", e);
        } finally {
            producer.close();
        }

    }

    private static Properties getProperties() {
        Properties props = new Properties();
        try (InputStream inputStream = new FileInputStream(AppConfig.KAFKA_CONFIGFILE_LOCATION)) {
            props.load(inputStream);
            props.put(ProducerConfig.CLIENT_ID_CONFIG, AppConfig.APPLICATION_ID);
            props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
            props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return props;
    }
}
