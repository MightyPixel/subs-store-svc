package subs.store.svc.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import javax.inject.Inject;
import subs.store.svc.model.Subscription;
import subs.store.svc.model.value.SubscriptionNumber;
import subs.store.svc.repository.SubscriptionRepo;

@Controller("/subscription")
public class SubscriptionController {

  @Inject private SubscriptionRepo subscriptionRepo;

  @Get("/user/{userId}")
  public HttpResponse<Subscription> findSubscriptionsByUser(final String userId) {
    final Subscription subscription = subscriptionRepo.findSubscription(userId);
    return HttpResponse.ok(subscription);
  }
}
