package com.example.demo;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @ResponseBody
    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/introduce")
    public String introduce(@RequestParam(defaultValue = "권민상")String name, Model model) {
        return "hello";
    }
}
