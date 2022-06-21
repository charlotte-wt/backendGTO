package com.example.gto.Events;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@Component
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
    private String title;

    @NotBlank
    private String description;

    public Event(String username, String email, String title, String description) {
        this.username = username;
        this.email = email;
        this.title = title;
        this.description = description;
    }


}
