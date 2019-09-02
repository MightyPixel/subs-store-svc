package subs.store.svc.controller;

import com.ft.membership.logging.OperationContext;
import com.ft.membership.logging.SimpleOperationContext;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import javax.inject.Inject;
import org.slf4j.MDC;
import subs.store.svc.model.Subscription;
import subs.store.svc.repository.SubscriptionRepo;

@Controller("/subscription")
public class SubscriptionController {

  @Inject private SubscriptionRepo subscriptionRepo;

  @Get("/user/{userId}")
  public HttpResponse<Subscription> findSubscriptionsByUser(final String userId) throws Exception{
    OperationContext operation = SimpleOperationContext.operation("findSubscriptionsByUser", this).started();
    final Subscription subscription = subscriptionRepo.findSubscription(userId);
    operation.wasSuccessful(subscription);
    MDC.clear();
    return HttpResponse.ok(subscription);
  }
}
