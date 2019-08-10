package subs.store.svc;

import io.micronaut.runtime.Micronaut;
import io.opentracing.util.GlobalTracer;

public class Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class);
    }
}