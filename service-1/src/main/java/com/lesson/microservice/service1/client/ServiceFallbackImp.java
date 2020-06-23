package com.lesson.microservice.service1.client;

import org.springframework.stereotype.Component;

@Component
public class ServiceFallbackImp implements Service {

    @Override
    public String sayHi() {
        return "Not reachable.";
    }


}
