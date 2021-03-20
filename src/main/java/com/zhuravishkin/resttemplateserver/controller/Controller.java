package com.zhuravishkin.resttemplateserver.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhuravishkin.resttemplateserver.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "server")
public class Controller {
    private final ObjectMapper objectMapper;

    public Controller(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @GetMapping(value = "/get")
    public ResponseEntity<User> get() {
        User user = new User("Sam", 30);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping(value = "/post")
    public ResponseEntity<User> post(@RequestParam String surname, @RequestBody String body) {
        User user = null;
        try {
            user = objectMapper.readValue(body, User.class);
            user.setName(user.getName() + " " + surname);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage(), e);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
