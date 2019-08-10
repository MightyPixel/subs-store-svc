package subs.store.svc.kafka.reader;

import io.micronaut.configuration.kafka.ConsumerAware;
import io.micronaut.configuration.kafka.KafkaAcknowledgement;
import io.micronaut.configuration.kafka.KafkaConsumerAware;
import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.Topic;
import java.util.Collection;
import javax.annotation.Nonnull;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRebalanceListener;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import subs.store.svc.dto.SubscriptionChangedMessage;

@KafkaListener(
//    offsetReset = OffsetReset.EARLIEST,
//    offsetStrategy = OffsetStrategy.DISABLED,
//    groupId = "${micronaut.application.name}"
)
public class SubscriptionChangedReader
    implements ConsumerRebalanceListener, ConsumerAware {

  private Consumer consumer;

  @Topic("subscription-changed")
  // @SendTo("subscription-change-stored")
  public void subscriptionChanged(
      ConsumerRecord<String, SubscriptionChangedMessage> record, KafkaAcknowledgement acknowledgement) {
    // Subscription subscription = record.value();
    // String id = record.key();
    System.out.println(record);
  }

  @Override
  public void onPartitionsRevoked(Collection<TopicPartition> partitions) {
    // save offsets here
  }

  @Override
  public void onPartitionsAssigned(Collection<TopicPartition> partitions) {
      for (TopicPartition partition : partitions) {
        consumer.seek(partition, 1);
      }
  }

  @Override
  public void setKafkaConsumer(@Nonnull Consumer consumer) {
    this.consumer = consumer;
  }
}
