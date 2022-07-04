package com.example.gto.Blog;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Document(collection = "category")
public class Category {
    @Id
    private String id;
    @NotBlank
    private String name;

    public Category() {

    }
    public Category (String name)  {
        this.name = name;
    }

}
