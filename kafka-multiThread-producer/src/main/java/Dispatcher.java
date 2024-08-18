import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dispatcher implements Runnable{
    private final String fileLocation;
    private final Logger logger = LoggerFactory.getLogger(Dispatcher.class);
    private final String topic;
    private final KafkaProducer<String, String> producer;

    public Dispatcher(KafkaProducer<String, String> producer, String topic, String fileLocation ) {
        this.producer = producer;
        this.topic = topic;
        this.fileLocation = fileLocation;
    }

    @Override
    public void run() {
        logger.info("Start Processing" + fileLocation );
        File file = new File(fileLocation);
        try (Scanner scanner = new Scanner(file)) {
            int cnt = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                producer.send(new ProducerRecord<>(topic, line));
                cnt++;
            }
            logger.info("Finished sending " + cnt +
                    " records from " + fileLocation +
                    "to topic " + topic);
        }
        catch (FileNotFoundException e) {
            logger.error(e.getMessage());
        }

    }
}
