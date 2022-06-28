package com.example.gto.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("")
    @PreAuthorize("permitAll()")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

//    @GetMapping("{id}")
//    @PreAuthorize("permitAll()")
//    public User getUserById(@PathVariable("id") String id) {
//        User userData = userRepository.findByUserId(id);
//        return userData;
//    }

//    @PutMapping("{id}")
//    @PreAuthorize("hasRole('USER') hasRole('MODERATOR') or hasRole('ADMIN')")
//    public ResponseEntity<User> updateUserBlogs(@PathVariable("id") Blog blog, @RequestBody User user) {
//        Optional<User> userData = userRepository.findById(user.getId());
//
//        if (userData.isPresent()) {
//            User _user = userData.get();
//            Set<Blog> _blogs = user.getBlogs();
//            _blogs.add(blog);
//            _user.setBlogs(_blogs);
//            return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }


}
