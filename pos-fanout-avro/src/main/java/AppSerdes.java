import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import types.HadoopRecord;
import types.Notification;
import types.PosInvoice;
import java.util.HashMap;
import java.util.Map;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;

public class AppSerdes extends Serdes {


    public static Serde<PosInvoice> PosInvoice() {
        Serde<PosInvoice> serde = new SpecificAvroSerde<>();

        Map<String, Object> serdeConfigs = new HashMap<>();
        serdeConfigs.put("schema.registry.url", AppConfigs.schemaRegistryURL);
        serde.configure(serdeConfigs, false);

        return serde;
    }

    public static Serde<Notification> Notification() {
        Serde<Notification> serde = new SpecificAvroSerde<>();

        Map<String, Object> serdeConfigs = new HashMap<>();
        serdeConfigs.put("schema.registry.url", AppConfigs.schemaRegistryURL);
        serde.configure(serdeConfigs, false);

        return serde;
    }

    public static Serde<HadoopRecord> HadoopRecord() {
        Serde<HadoopRecord> serde = new SpecificAvroSerde<>();

        Map<String, Object> serdeConfigs = new HashMap<>();
        serdeConfigs.put("schema.registry.url", AppConfigs.schemaRegistryURL);
        serde.configure(serdeConfigs, false);

        return serde;
    }

}