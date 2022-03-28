package com.example.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * todo description
 *
 * @author qpzm7903
 * @since 2022-03-28-22:22
 */
@RestController
public class ServiceController {
    @GetMapping("/service")
    public Object serviceInfo() {
        Map<String, Object> map = new HashMap<>();
        map.put("name","service");
        map.put("age",10);
        map.put("address","/c/cc/c/c/c");
        return map;
    }

}
