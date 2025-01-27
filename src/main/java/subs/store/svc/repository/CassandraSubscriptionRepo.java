package subs.store.svc.repository;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Row;
import com.ft.membership.logging.OperationContext;
import com.ft.membership.logging.SimpleOperationContext;
import io.micronaut.context.annotation.Requires;
import io.micronaut.context.env.Environment;
import io.micronaut.tracing.annotation.NewSpan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import subs.store.svc.model.Subscription;

import javax.inject.Singleton;

@Singleton
@Requires(beans = Cluster.class, notEnv = Environment.TEST)
public class CassandraSubscriptionRepo implements SubscriptionRepo {

  private final String SUBS_STORE_KEYSPACE = "subs_store";
  private final String SUBSCRIPTIONS_BY_USER_TABLE = "subscriptions_by_user";
  private final Cluster cluster;
  private static final Logger LOG = LoggerFactory.getLogger(CassandraSubscriptionRepo.class);

  CassandraSubscriptionRepo(Cluster cluster) {
    this.cluster = cluster;
  }

  @NewSpan("findSubscription")
  public Subscription findSubscription(final String userId) {
    try (OperationContext action = SimpleOperationContext.action("findSubscription", this).started()) {
      final Row row =
          cluster
              .connect(SUBS_STORE_KEYSPACE)
              .execute("SELECT * FROM " + SUBSCRIPTIONS_BY_USER_TABLE + " WHERE user_id=" + userId)
              .one();
      action.wasSuccessful(row);
      return Subscription.from(row);
    }
  }
}
