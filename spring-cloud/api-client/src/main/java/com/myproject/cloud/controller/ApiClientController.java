package com.myproject.cloud.controller;

import com.myproject.cloud.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/api")
@RestController
public class ApiClientController {

    private final HelloService helloService;

    @Autowired
    public ApiClientController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping(value = "/hello")
    public String hello() {
        return helloService.hello("api client");
    }

}
