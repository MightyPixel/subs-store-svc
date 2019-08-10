package subs.store.svc.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/")
public class SystemController {

  @Get(value = "/__gtg", produces = MediaType.TEXT_PLAIN)
  public String gtg() {
    return "OK";
  }

  @Get(value = "/__health", produces = MediaType.APPLICATION_JSON)
  public HttpResponse health() {

    return HttpResponse.ok();
  }
}
