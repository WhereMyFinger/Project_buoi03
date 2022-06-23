package com.example.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/greeting")
    public Greeting greet(@RequestParam(name = "id", defaultValue = "1") Integer id,
                          @RequestParam(name = "name", defaultValue = "World") String name) {
        Greeting greeting = new Greeting();
        greeting.setId(id);
        greeting.setContent("Hello, " + name + "!");
        return greeting;
    }
}
