package subs.store.svc.controller;

import io.micronaut.context.ApplicationContext;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.runtime.server.EmbeddedServer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SystemControllerTest {

  @Test
  public void testGtg() throws Exception {
    try (EmbeddedServer server = ApplicationContext.run(EmbeddedServer.class)) {
      try (RxHttpClient client =
          server.getApplicationContext().createBean(RxHttpClient.class, server.getURL())) {
        assertEquals("OK", client.toBlocking().retrieve("/__gtg"));
      }
    }
  }

  @Test
  public void testHealth() throws Exception {
    try (EmbeddedServer server = ApplicationContext.run(EmbeddedServer.class)) {
      try (RxHttpClient client =
          server.getApplicationContext().createBean(RxHttpClient.class, server.getURL())) {
        assertEquals(HttpStatus.OK, client.toBlocking().exchange("/__health").status());
      }
    }
  }
}
