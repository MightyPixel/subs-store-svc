package subs.store.svc.service;

import io.micronaut.tracing.annotation.ContinueSpan;
import io.micronaut.tracing.annotation.NewSpan;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import subs.store.svc.kafka.writer.PurgeWriter;
import subs.store.svc.repository.CassandraSubscriptionRepo;

@Singleton
public class PurgeService {
  private static final Logger LOG = LoggerFactory.getLogger(CassandraSubscriptionRepo.class);

  @Inject
  private PurgeWriter purgeWriter;

  public boolean purge(String userId) {
    LOG.info("Purging userId=" + userId);
    purgeWriter.sendPurgeConfirmation(userId, "Purged");

    return true;
  }
}
