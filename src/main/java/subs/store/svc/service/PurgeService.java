package subs.store.svc.service;

import com.ft.membership.logging.OperationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import subs.store.svc.kafka.writer.PurgeWriter;
import subs.store.svc.repository.CassandraSubscriptionRepo;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class PurgeService {
  private static final Logger LOG = LoggerFactory.getLogger(CassandraSubscriptionRepo.class);

  @Inject
  private PurgeWriter purgeWriter;

  public boolean purge(String userId) {
    LOG.info("Purging userId=" + userId);
    OperationContext action = OperationContext.action("purge", this).with("userId", userId).started();
    purgeWriter.sendPurgeConfirmation(userId, "Purged");

    action.wasSuccessful();
    return true;
  }
}
