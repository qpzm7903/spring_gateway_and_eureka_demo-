package com.example.client.controller;

import com.example.client.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * todo description
 *
 * @author qpzm7903
 * @since 2022-03-28-22:24
 */
@RestController
public class ClientController {

    @Autowired
    @Qualifier("default")
    RestTemplate restTemplate;

    @Autowired
    @Qualifier("lb")
    RestTemplate lbRestTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/client/v1")
    Object clientV1() {
        return restTemplate.getForObject("http://127.0.0.1:9010/service", String.class);
    }

    @GetMapping("/client/v2")
    Object clientV2() {
        ServiceInstance service = loadBalancerClient.choose("service");
        String url = String.format("http://%s:%s/service", service.getHost(), service.getPort());
        return restTemplate.getForObject(url, String.class);
    }


    @GetMapping("/client/v3")
    Object clientV3() {
        return lbRestTemplate.getForObject(String.format("http://%s/service", "service"), String.class);
    }

    @Autowired
    Service service;

    @GetMapping("/client/v4")
    Object clientV4() {
        return service.get();
    }


}
