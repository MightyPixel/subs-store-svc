package subs.store.svc.client;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import subs.store.svc.model.Subscription;

@Client("/subscription")
public interface SubscriptionClient {

  @Get("/user/1")
  HttpResponse<Subscription> fetchSubscription();

}
