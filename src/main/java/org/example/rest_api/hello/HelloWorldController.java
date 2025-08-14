package org.example.rest_api.hello;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

    @GetMapping(path = "/basicauth")
    public String basicAuthCheck() {
        return "Success";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World");
    }

    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }
}