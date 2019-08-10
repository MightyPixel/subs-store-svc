package subs.store.svc.kafka.writer;

import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.Topic;

@KafkaClient
public interface PurgeWriter {
  @Topic("gdpr")
  void sendPurgeConfirmation(@KafkaKey String userId, String info);
}
