package com.FuzzySearch.FuzzyApi.Model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="foodItems")

public class foodItems {
    private Long Id;
    private String Name;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
