package subs.store.svc.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import javax.inject.Inject;
import subs.store.svc.service.PurgeService;

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
