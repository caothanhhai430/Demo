package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/user")
public class APITest {

    @Autowired
    Data data;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity listUser(){
        return ResponseEntity.status(200).body(data.getUserList());
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity newUser(@RequestBody User user){
        user.setCode(UUID.randomUUID().toString());
        data.addUser(user);
        return ResponseEntity.status(200).body(user);
    }

    @RequestMapping(value = "/{code}", method = RequestMethod.GET)
    public ResponseEntity detailUser(@PathVariable String code){
        Optional<User> user = data.findByCode(code);
        return user.isPresent() ? ResponseEntity.ok(user.get()) : ResponseEntity.notFound().build();
    }
}
