package subs.store.svc.controller;

import com.ft.membership.logging.CompoundOperation;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import subs.store.svc.model.Subscription;
import subs.store.svc.repository.SubscriptionRepo;

import javax.inject.Inject;

@Controller("/subscription")
public class SubscriptionController {

  @Inject private SubscriptionRepo subscriptionRepo;

  @Get("/user/{userId}")
  public HttpResponse<Subscription> findSubscriptionsByUser(final String userId) {
    CompoundOperation operation = CompoundOperation.operation("findSubscriptionsByUser", this).started();
    final Subscription subscription = subscriptionRepo.findSubscription(userId);
    operation.wasSuccessful(subscription);
    return HttpResponse.ok(subscription);
  }
}
