package com.czhspringreview.ioc;

import com.czhspringreview.entity.Student;

public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springioc.xml");
        Student student = (Student) applicationContext.getBean("student");
        System.out.println(student);
    }
}
