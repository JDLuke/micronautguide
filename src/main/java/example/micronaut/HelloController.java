package example.micronaut;

import domain.Hello;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

@Controller()
public class HelloController {
    @Get("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return new Hello().sayHello();
    }
}
