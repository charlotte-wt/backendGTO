package com.example.gto.User;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "role")
public class Role {

    @Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)
    private @Id String id;


    private String role;
}
