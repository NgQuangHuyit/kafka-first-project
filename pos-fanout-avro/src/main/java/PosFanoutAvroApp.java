import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import types.PosInvoice;

import java.util.Properties;

public class PosFanoutAvroApp {
    final static Logger logger = LoggerFactory.getLogger(PosFanoutAvroApp.class);

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, AppConfigs.applicationID);
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, AppConfigs.bootstrapServers);

        StreamsBuilder streamsBuilder = new StreamsBuilder();

        KStream<String, PosInvoice> kStream00 = streamsBuilder.stream(AppConfigs.posTopicName,
                Consumed.with(AppSerdes.String(), AppSerdes.PosInvoice()));

        Produced<String, PosInvoice> produced = Produced.with(AppSerdes.String(), AppSerdes.PosInvoice());
        kStream00.filter((k, v) ->
                v.getDeliveryType().toString().equalsIgnoreCase(AppConfigs.DELIVERY_TYPE_HOME_DELIVERY))
                .to(AppConfigs.shipmentTopicName, Produced.with(AppSerdes.String(), AppSerdes.PosInvoice() ));

        kStream00.filter((k, v) -> v.getCustomerType().toString().equalsIgnoreCase(AppConfigs.CUSTOMER_TYPE_PRIME))
                .mapValues(RecordBuilder::getNotification)
                .to(AppConfigs.notificationTopic,
                        Produced.with(AppSerdes.String(), AppSerdes.Notification()));

        kStream00.mapValues(RecordBuilder::getMaskedInvoice)
                .flatMapValues(RecordBuilder::getHadoopRecords)
                .to(AppConfigs.hadoopTopic,
                        Produced.with(AppSerdes.String(),AppSerdes.HadoopRecord()));

        KafkaStreams streams = new KafkaStreams(streamsBuilder.build(), props);
        streams.start();
        logger.info("Application started");

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            streams.close();
            logger.info("Shutting down");
        }));
    }
}
