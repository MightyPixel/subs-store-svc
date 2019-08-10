package subs.store.svc.repository;

import subs.store.svc.model.Subscription;

public interface SubscriptionRepo {

  Subscription findSubscription(final String userId);
}
