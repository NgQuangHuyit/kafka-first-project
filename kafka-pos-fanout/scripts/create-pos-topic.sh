docker exec kafka1 kafka-topics --bootstrap-server kafka1:19092 --create --replication-factor 3 --partitions 3 --topic pos --config min.insync.replicas=2