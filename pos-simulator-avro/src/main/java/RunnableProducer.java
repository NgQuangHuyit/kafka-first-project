import datagenerator.InvoiceGenerator;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import types.PosInvoice;

import java.util.concurrent.atomic.AtomicBoolean;

public class RunnableProducer implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(RunnableProducer.class.getName());
    private final AtomicBoolean stopper = new AtomicBoolean(false);
    private KafkaProducer<String, PosInvoice> producer;
    private String topicName;
    private InvoiceGenerator invoiceGenerator;
    private int produceSpeed;
    private int id;

    RunnableProducer(int id, KafkaProducer<String, PosInvoice> producer, String topicName, int produceSpeed) {
        this.id = id;
        this.producer = producer;
        this.topicName = topicName;
        this.produceSpeed = produceSpeed;

        this.invoiceGenerator = InvoiceGenerator.getInstance();
    }
    @Override
    public void run() {
        try {
            logger.info("Starting producer thread - " + id);
            while (!stopper.get()) {
                logger.info("---------");
                PosInvoice posInvoice = invoiceGenerator.getNextInvoice();
                logger.info("***************");
                logger.info(posInvoice.toString());
                producer.send(new ProducerRecord<>(topicName, posInvoice.getStoreID().toString(), posInvoice));
                logger.info("Thread" + id + "sent");
                Thread.sleep(produceSpeed);
            }

        } catch (Exception e) {
            logger.error("Exception in Producer thread - " + id);
            throw new RuntimeException(e);
        }

    }

    void shutdown() {
        logger.info("Shutting down producer thread - " + id);
        stopper.set(true);

    }
}
