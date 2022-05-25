package com.example.gto.User;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;



@Getter
@Setter
@ToString
@Component
public class User {

    @Field("email")
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

    protected User() {}

    public User(String userName, String email, String phoneNum, String password) {
        this.userName = userName;
        this.email = email;
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
