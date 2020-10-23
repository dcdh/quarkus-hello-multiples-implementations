package org.acme.getting.started;

import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @Named("english")
    SayHello sayHelloInEnglish;

    @Named("french")
    SayHello sayHelloInFrench;

    @GET
    @Path("/english")
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHelloInEnglish() {
        return sayHelloInEnglish.hello();
    }

    @GET
    @Path("/french")
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHelloInFrench() {
        return sayHelloInFrench.hello();
    }

}