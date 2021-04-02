//package com.example.demo;
//
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Component
//public class Data {
//    private List<User> userList = new ArrayList<>();
//
//    public List<User> getUserList() {
//        return userList;
//    }
//
//    public void addUser(User user){
//        userList.add(user);
//    }
//
//    public Optional<User> findByCode(String code){
//        return userList.stream().filter(u -> u.getCode().equals(code)).findFirst();
//    }
//}
