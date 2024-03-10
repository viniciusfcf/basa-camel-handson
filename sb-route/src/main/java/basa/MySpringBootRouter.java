package basa;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

/**
 * A simple Camel route that triggers from a timer and calls a bean and prints to system out.
 * <p/>
 * Use <tt>@Component</tt> to make Camel auto detect this route when starting.
 */
@Component
public class MySpringBootRouter extends RouteBuilder {

    @Override
    public void configure() {

        restConfiguration().component("servlet").host("localhost").port(8080).bindingMode(RestBindingMode.auto);

        rest("/")
            .get("ordem").routeId("post-route")
                .to("direct:cadastrarOrdem");

        ;

        from("direct:cadastrarOrdem")
            .setBody(constant("OK"))
            .to("kafka:ordens")
            .setHeader(Exchange.CONTENT_TYPE, constant("plain/text"))
        ;

        // from("timer:hello?period={{timer.period}}").routeId("hello")
        //     .transform().method("myBean", "saySomething")
        //     .filter(simple("${body} contains 'foo'"))
        //         .to("log:foo")
        //     .end()
        //     .to("stream:out");
    }

}
