package com.example.demo;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/introduce")
    public String introduce(@RequestParam(required = false, defaultValue = "권민상")String name, Model model) {
        return String.format("반갑습니다 제 이름은 %s이라고 합니다.",name);
    }
}
