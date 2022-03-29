



# 通过服务发现调用

有诸多好处

- 不关注实际的实现地址

- 可以进行动态负载均衡







# 通过client调用service



# ## 直接rest拼接ip+端口



```shell
PS C:\Users\qpzm7903> curl http://localhost:9000/client/v1                                                                                                                                                                                                                                                                                                              StatusCode        : 200
Content   : {"address":"/c/cc/c/c/c","name":"service","age":10}
                                                                                                                                                                                                                                                                                                                                                                        PS C:\Users\qpzm7903> curl http://localhost:9000/client/v2                                             PS C:\Users\qpzm7903> curl http://localhost:9000/client/v2 PS C:\Users\qpzm7903> curl http://localhost:9000/client/v2        : {}
```



## 通过服务发现获取ip和端口

```shell
PS C:\Users\qpzm7903> curl http://localhost:9000/client/v2                                                              
Content           : {"address":"/c/cc/c/c/c","name":"service","age":10}
```





## 通过服务名调用

```shell
PS C:\Users\qpzm7903> curl http://localhost:9000/client/v3
Content           : {"address":"/c/cc/c/c/c","name":"service","age":10}


```



## 通过Feign调用，需要函数签名一致

```shell
PS C:\Users\qpzm7903> curl http://localhost:9000/client/v4


StatusCode        : 200
StatusDescription :
Content           : {"address":"/c/cc/c/c/c","name":"service","age":10}
```





# 通过网关调用





## 编程式路由



```java
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/service")
                        .filters(f -> f.addRequestHeader("Hello", "World"))
                        .uri("http://localhost:9010/service"))
                .build();
    }
```



# 参考



https://segmentfault.com/a/1190000018531262

https://cloud.spring.io/spring-cloud-netflix/multi/multi_spring-cloud-eureka-server.html





[网关官方启动文档](https://spring.io/guides/gs/gateway/))



[网关官方参考文档](https://cloud.spring.io/spring-cloud-gateway/reference/html/)




