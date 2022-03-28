package com.example.client.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * todo description
 *
 * @author qpzm7903
 * @since 2022-03-28-23:18
 */

@FeignClient("service")
public interface Service {
    /**
     * 需要和service中实际定义的一致
     * @return
     */
    @GetMapping("/service")
    Object get();
}
