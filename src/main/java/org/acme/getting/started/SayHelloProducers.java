package org.acme.getting.started;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

public class SayHelloProducers {

    @ApplicationScoped
    @Produces
    @Named("english")
    public SayHello sayHelloInEnglish() {
        return () -> "hello";
    }

    @ApplicationScoped
    @Produces
    @Named("french")
    public SayHello sayHelloInFrench() {
        return () -> "bonjour";
    }

}
