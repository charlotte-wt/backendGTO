package com.example.gto.Blog;

import com.example.gto.User.User;
import com.example.gto.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@CrossOrigin
@RestController
@RequestMapping("/api/blogs")
public class BlogController {
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private UserRepository userRepository;


    @GetMapping("")
    @PreAuthorize("permitAll()")
    public ResponseEntity<List<Blog>> getAllBlogs(@RequestParam(required = false) String title) {
        try {
            List<Blog> blogs = new ArrayList<Blog>();

            if (title == null)
                blogRepository.findAll().forEach(blogs::add);
            else
                blogRepository.findByTitleContaining(title).forEach(blogs::add);

            if (blogs.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(blogs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Blog> addBlog(@Valid @RequestBody Blog blog) {
        try {
            Blog _blog = blogRepository.save(blog);
            String userId = blog.getUserId();
            Optional<User> userData = userRepository.findById(userId);

//           if (userData.isPresent()) {
            User _user = userData.get();
            Set<Blog> userBlogs = _user.getBlogs();
            userBlogs.add(blog);
            _user.setBlogs(userBlogs);
            userRepository.save(_user);
//          }


            return new ResponseEntity<>(_blog, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("{id}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Blog> updateBlog(@PathVariable("id") String id, @RequestBody Blog blog) {
        Optional<Blog> blogData = blogRepository.findById(id);

        if (blogData.isPresent()) {
            Blog _blog = blogData.get();
            _blog.setTitle(blog.getTitle());
            _blog.setDescription(blog.getDescription());
            _blog.setImage(blog.getImage());
            _blog.setUserId(blog.getUserId());
            return new ResponseEntity<>(blogRepository.save(_blog), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("{id}")
    @PreAuthorize("permitAll()")
    public ResponseEntity<Blog> getBlogById(@PathVariable("id") String id) {
        Optional<Blog> eventData = blogRepository.findById(id);

        if (eventData.isPresent()) {
            return new ResponseEntity<>(eventData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Blog> deleteBlog(@PathVariable("id") String id) {
        try {
            blogRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("user")
    @PreAuthorize("permitAll()")
    public ResponseEntity<Blog> getBlogByUser(@PathVariable("id") String userId) {
        Optional<Blog> userData = blogRepository.queryBlogByUser(userId);

        if (userData.isPresent()) {
            return new ResponseEntity<>(userData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }





}
