package com.zhuravishkin.resttemplateserver.controller;

import com.zhuravishkin.resttemplateserver.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "template")
public class Controller {
    @GetMapping(value = "/get")
    public ResponseEntity<User> get() {
        User user = new User("Sam", 30);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping(value = "/post")
    public ResponseEntity<User> post(@RequestParam String name, @RequestParam Integer age) {
        User user = new User(name, age);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
