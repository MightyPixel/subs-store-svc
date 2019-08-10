package subs.store.svc.controller;

import static org.junit.Assert.assertEquals;

import io.micronaut.context.ApplicationContext;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.runtime.server.EmbeddedServer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import subs.store.svc.model.Subscription;

// @MicronautTest(environments = Environment.TEST)
public class SubscriptionControllerTest {

  // @Shared
  // @AutoCleanup
  private static EmbeddedServer server;

  // @Shared
  // @AutoCleanup
  private static HttpClient subscriptionClient;

  @BeforeClass
  public static void setupServer() {
    server = ApplicationContext.run(EmbeddedServer.class);
    subscriptionClient = HttpClient.create(server.getURL());
  }

  @AfterClass
  public static void stopServer() {
    if (server != null) {
      server.close();
    }
    if (subscriptionClient != null) {
      subscriptionClient.close();
    }
  }

  @Test
  public void testFindUser() {
    final HttpResponse<Subscription> response =
        subscriptionClient.toBlocking().exchange("/subscription/user/1", Subscription.class);
    assertEquals(response.status(), HttpStatus.OK);
    // assertEquals(response.body().getSubscriptionNumber().getValue(), "123");
  }
}
