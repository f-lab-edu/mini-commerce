package com.flab.commerce.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/ok")
    public String success() {
        return "ok";
    }

    @GetMapping("/hello")
    public String hello(@RequestParam String hello) {
        return hello;
    }
}
