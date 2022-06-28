package com.example.gto.Blog;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Document(collection="blog")
public class Blog {

    @Id
    private String id;


    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @NotBlank
    private String image;

    @NotBlank
    private String userId;

    @DBRef
    Set<Category> categories = new HashSet<>();

    public Blog() {

    }
    public Blog(String title, String description, String image, String userId) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.userId = userId;
    }


}
