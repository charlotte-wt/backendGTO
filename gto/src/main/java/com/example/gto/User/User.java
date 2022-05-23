package com.example.gto.User;


import org.springframework.data.annotation.Id;


public class User {


    @Id
    public String email;

    public String userName;

    public String phoneNum;

    public String password;

    public User() {}

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
