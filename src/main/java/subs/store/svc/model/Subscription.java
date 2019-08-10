package subs.store.svc.model;

import com.datastax.driver.core.Row;
import java.io.Serializable;
import subs.store.svc.model.value.SubscriptionNumber;
import subs.store.svc.model.value.SubscriptionProvider;

public class Subscription implements Serializable {
  private static final long serialVersionUID = 123L;

  private SubscriptionNumber subscriptionNumber;
  private SubscriptionProvider subscriptionProvider;

  Subscription(
      SubscriptionNumber subscriptionNumber,
      SubscriptionProvider subscriptionProvider
  ) {
    this.subscriptionNumber = subscriptionNumber;
    this.subscriptionProvider = subscriptionProvider;
  }

  public SubscriptionNumber getSubscriptionNumber() {
    return subscriptionNumber;
  }

  public SubscriptionProvider getSubscriptionProvider() {
    return subscriptionProvider;
  }

  public static Subscription from(Row row) {
    final String id = row.getString("subscription_id");
    final String subscriptionProvider = row.getString("subscription_provider");
    return of(id, subscriptionProvider);
  }

  public static Subscription of(final String subscriptionNumber, final String subscriptionProvider) {
    return new Subscription(
        SubscriptionNumber.from(subscriptionNumber),
        SubscriptionProvider.from(subscriptionProvider)
    );
  }

}