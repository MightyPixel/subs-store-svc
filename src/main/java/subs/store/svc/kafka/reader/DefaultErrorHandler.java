package subs.store.svc.kafka.reader;

import io.micronaut.configuration.kafka.exceptions.DefaultKafkaListenerExceptionHandler;
import io.micronaut.context.annotation.Replaces;

@Replaces(DefaultKafkaListenerExceptionHandler.class)
public class DefaultErrorHandler {
}
