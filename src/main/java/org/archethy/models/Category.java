package org.archethy.models;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Category {

    private String name;

    public Category() {}

    public Category(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                '}';
    }
}