package com.myproject.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "api-server", path = "/")
public interface HelloService {

    @GetMapping(value = "/hello")
    String hello(@RequestParam String name);

}
