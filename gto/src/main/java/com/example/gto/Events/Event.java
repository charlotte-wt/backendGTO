package com.example.gto.Events;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class Event {

    @Id
    private int id;

    @NotBlank
    @Size(max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    private String description;

    public Event(String username, String email, String description) {
        this.username = username;
        this.email = email;
        this.description = description;
    }


}
