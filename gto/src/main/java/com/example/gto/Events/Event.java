package com.example.gto.Events;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@Document(collection="event")
public class Event {

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
    private String title;

    @NotBlank
    private String description;

    public Event() {

    }
    public Event(String username, String email, String title, String description) {
        this.username = username;
        this.email = email;
        this.title = title;
        this.description = description;
    }


}
