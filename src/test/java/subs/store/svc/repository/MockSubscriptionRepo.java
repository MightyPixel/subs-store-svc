package subs.store.svc.repository;

import io.micronaut.context.annotation.Requires;
import io.micronaut.context.env.Environment;
import javax.inject.Singleton;
import subs.store.svc.model.Subscription;

@Singleton
@Requires(env = Environment.TEST)
public class MockSubscriptionRepo implements SubscriptionRepo {

  @Override
  public Subscription findSubscription(String userId) {
    return Subscription.of("123", "google");
  }
}
