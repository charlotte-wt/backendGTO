package com.example.gto.User;

import com.example.gto.Blog.Blog;
import com.example.gto.Role.Role;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@ToString
@Document(collection="user")
public class User {

    @Id
    private String id;
    @NotBlank
    @Size(max = 20)
    private String username;
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(max = 120)
    private String password;
    @DBRef
    private Set<Role> roles = new HashSet<>();

    private Set<Blog> blogs = new HashSet<>();

    protected User() {}

    public User(String userName, String email, String password) {
        this.username = userName;
        this.email = email;
        this.password = password;

    }

//    public User(String userName, String email, String password) {
//        this.username = userName;
//        this.email = email;
//        this.password = password;
//
//    }

    @Override
    public String toString() {
        return String.format(
                "User[userName=%s, email='%s']",
                username, email);
    }



}
