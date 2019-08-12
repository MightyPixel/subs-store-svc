package subs.store.svc.config;

import brave.propagation.CurrentTraceContext;
import com.ft.membership.logging.OperationContext;
import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.discovery.event.ServiceStartedEvent;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ApplicationConfig implements ApplicationEventListener<ServiceStartedEvent> {
    @Inject
    private CurrentTraceContext currentTraceContext;

    @Override
    public void onApplicationEvent(ServiceStartedEvent event) {
        OperationContext.setOperationIdentity(() -> String.valueOf(currentTraceContext.get().traceId()));
    }
}
