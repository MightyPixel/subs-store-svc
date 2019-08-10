package subs.store.svc.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import subs.store.svc.service.PurgeService;

import javax.inject.Inject;

@Controller("/purge")
public class PurgeController {
    @Inject
    private PurgeService purgeService;

  @Get("/user/{userId}")
  public HttpResponse purgeUserInfo(final String userId) {
    purgeService.purge(userId);
    return HttpResponse.ok();
  }
}
