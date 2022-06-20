package com.example.gto.Friends;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class Friends {
    @Id
    private int id;

    @NotBlank
    private String username;
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    public Friends(String userName, String email) {
        this.username = userName;
        this.email = email;

    }


}
