package com.example.gto.User;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import java.util.Set;


@Getter
@Setter
@ToString
@Document(collection = "user")
public class User {


    @Indexed(unique = true)
    @NotNull
    private @Id String email;

    @Field("userName")
    @NotNull
    private String userName;

    @Field("phoneNum")
    private String phoneNum;

    @Field("password")
    @NotNull
    private String password;


    @DBRef
    private Set<Role> roles;

    protected User() {}

    public User(String email, String userName, String phoneNum, String password) {
        this.email = email;
        this.userName = userName;
        this.phoneNum = phoneNum;
        this.password = password;

    }

    @Override
    public String toString() {
        return String.format(
                "User[userName=%s, email='%s']",
                userName, email);
    }



}
