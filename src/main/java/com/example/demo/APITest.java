package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class APITest {

    @Autowired
    UserRepository repository;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity listUser() {
        Iterable<User> list = repository.findAll();
        return ResponseEntity.status(200).body(list);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity newUser(@RequestBody User user) {
        user = repository.save(user);
        return ResponseEntity.status(200).body(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity detailUser(@PathVariable String id) {
        User user = repository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return ResponseEntity.status(200).body(user);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity detailUser(@PathVariable String id, @RequestBody User user) {
        User oldUser = repository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        oldUser.setEmail(user.getEmail());
        oldUser.setName(user.getName());
        oldUser.setPhone(user.getPhone());
        oldUser = repository.save(oldUser);
        return ResponseEntity.status(200).body(oldUser);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteUser(@PathVariable String id) {
        User user = repository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        repository.delete(user);
        return ResponseEntity.status(200).body(String.format("remove user with %s success",id));
    }
}
