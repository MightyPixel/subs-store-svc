package subs.store.svc.kafka.reader;

import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.Topic;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import subs.store.svc.service.PurgeService;

@KafkaListener(groupId = "${micronaut.application.name}")
public class PurgeReader {
  private static final Logger LOG = LoggerFactory.getLogger(PurgeReader.class);

  @Inject private PurgeService purgeService;

  @Topic("purge-requested")
  public void purgeRequested(
      @KafkaKey String userId,
      String reason,
      long offset,
      int partition,
      String topic,
      long timestamp) {

    LOG.info(
        String.format(
            "%s: %s (%d, %d, %s, %d", userId, reason, offset, partition, topic, timestamp));

    purgeService.purge(userId);
  }
}
