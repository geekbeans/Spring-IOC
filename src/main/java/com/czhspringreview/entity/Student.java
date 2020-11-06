package com.czhspringreview.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class Student {
    private long id;
    private int age;
    private String name;
    //private List<Address> addresses;
    private Address address;
//    public Student(){
//        System.out.println("Student无参构造");
   // }
}
