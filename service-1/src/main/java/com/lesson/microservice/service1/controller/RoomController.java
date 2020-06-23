package com.lesson.microservice.service1.controller;

import com.lesson.microservice.service1.client.Service;
import com.lesson.microservice.service1.entity.Room;
import com.lesson.microservice.service1.repository.RoomRepository;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.security.Principal;
import java.util.Collections;
import java.util.List;

@RestController
public class RoomController {
    @Autowired
    @Qualifier("serv")
    Service service;

    @Autowired
    RoomRepository roomRepository;


    @GetMapping(value = "/rooms")
    public List<Room> getRooms(@RequestParam(name = "roomNumber",required = false)String roomNumber) {
        if(StringUtils.isNotEmpty(roomNumber)) {
            return Collections.singletonList(this.roomRepository.findByRoomNumber(roomNumber)); //Return immutable list.
        }
        return (List<Room>) roomRepository.findAll();
    }

    @GetMapping("/home")
    public String howdy(Principal principal) {
        String username = principal.getName();
        JwtAuthenticationToken token = (JwtAuthenticationToken) principal;

        String message = this.service.sayHi();

        return "Hello, " + username + " " + message;
    }


}
