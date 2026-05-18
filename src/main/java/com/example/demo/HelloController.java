package com.example.demo;

import ch.qos.logback.core.model.Model;
import com.fasterxml.jackson.annotation.JsonAlias;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {
    @GetMapping("/introduce")
    public String hello() {
        return "hello";
    }

    @ResponseBody
    @GetMapping("/introduce")
    public String introduce(@RequestParam(required = false)String name, Model model) {
        return String.format("반갑습니다 제 이름은 %s이라고 합니다.",name);
    }

    @ResponseBody
    @GetMapping("/json")
    public InfoApi info() {
        InfoApi identification = new InfoApi();
        identification.setAge(20);
        identification.setName("권민상");
        return identification;
    }
}
