package com.czhspringreview.entity;

import lombok.Data;

@Data
public class User {
    private int id;
    private String name;
    private int age;

    public User(){
        System.out.println("User无参构造");
    }
}
