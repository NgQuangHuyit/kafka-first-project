import com.launchdarkly.eventsource.MessageEvent;
import com.launchdarkly.eventsource.background.BackgroundEventHandler;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class WikimediaChangesHandler implements BackgroundEventHandler {

    KafkaProducer<String, String> kafkaProducer;
    String topic;
    private final Logger log = LoggerFactory.getLogger(WikimediaChangesHandler.class.getSimpleName());

    public WikimediaChangesHandler(KafkaProducer<String, String> kafkaProducer, String topic) {
        this.kafkaProducer = kafkaProducer;
        this.topic = topic;
    }
    @Override
    public void onOpen() {

    }

    @Override
    public void onClosed() {
        kafkaProducer.close();
    }

    @Override
    public void onMessage(String s, MessageEvent messageEvent) {
        log.info(messageEvent.getData());
        kafkaProducer.send(new ProducerRecord<>(topic, messageEvent.getData()));
    }

    @Override
    public void onComment(String s) {

    }

    @Override
    public void onError(Throwable throwable) {
        log.error(throwable.getMessage());
    }
}
