package subs.store.svc.kafka.writer;

import io.micronaut.configuration.kafka.annotation.KafkaClient;
import java.util.concurrent.Future;
import javax.inject.Singleton;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import subs.store.svc.model.Subscription;

@Singleton
public class SubscriptionWriter {

  private final Producer<String, Subscription> subscriptionProducer;

  private final String SUBSCRIPTION_UPDATED_TOPIC = "subscription-updated";

  SubscriptionWriter(
      @KafkaClient("subscription-producer") Producer<String, Subscription> subscriptionProducer) {
    this.subscriptionProducer = subscriptionProducer;
  }

  public Future<RecordMetadata> sendSubscriptionUpdated(
      String key, final Subscription subscription) {

    ProducerRecord<String, Subscription> record = new ProducerRecord(
        SUBSCRIPTION_UPDATED_TOPIC,
        key,
        subscription
    );

   return subscriptionProducer.send(record);
  }
}
