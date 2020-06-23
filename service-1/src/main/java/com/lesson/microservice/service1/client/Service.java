package com.lesson.microservice.service1.client;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@Qualifier("serv")
@FeignClient(value = "SERVICE2",fallback = ServiceFallbackImp.class)
public interface Service {
    @GetMapping(value = "/hello")
    public String sayHi();


}
