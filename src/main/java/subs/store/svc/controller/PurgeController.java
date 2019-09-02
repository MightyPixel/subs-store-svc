package subs.store.svc.controller;

import com.ft.membership.logging.OperationContext;
import com.ft.membership.logging.SimpleOperationContext;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import subs.store.svc.service.PurgeService;

import javax.inject.Inject;

@Controller("/purge")
public class PurgeController {
  @Inject private PurgeService purgeService;

  @Get("/user/{userId}")
  public HttpResponse purgeUserInfo(final String userId) {
    OperationContext operation = SimpleOperationContext.operation("purgeUserInfo", this).started();
    purgeService.purge(userId);
    operation.wasSuccessful();
    return HttpResponse.ok();
  }
}
