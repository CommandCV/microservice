package com.myproject.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping(value = "/")
@RestController
public class HelloController {

    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/hello")
    public String hello(@RequestParam String name) {
        log.info("Received request parameter: {}", name);
        return "hello " + name + ", this is api server, port: " + port;
    }

}
