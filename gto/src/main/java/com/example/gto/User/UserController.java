//package com.example.gto.User;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.List;
//
//@RestController
//public class UserController {
//
//    @Autowired
//    private UserRepository users;
//
//
//    @GetMapping("/users")
//    public List<User> getUsers() {
//        return users.findAll();
//    }
//
//
//
//    @GetMapping("/findAllUsers/{email}")
//    public User getEmail(@PathVariable String email) {
//        return users.findByEmail(email);
//    }
//
//    @PostMapping("/addUser")
//    public String addUser(@Valid @RequestBody User user) {
//        users.save(user);
//        return "Added user with email : " + user.getEmail();
//    }
//
//    @DeleteMapping("/delete/{email}")
//    public String deleteUser(@PathVariable String email) {
//        users.deleteById(email);
//        return "book deleted with id : " + email;
//    }
//}
