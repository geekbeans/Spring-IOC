package com.czhspringreview;

import com.czhspringreview.entity.Address;
import com.czhspringreview.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringPTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring_p.xml");
        Student stu = (Student) applicationContext.getBean("student");
        Address address = (Address) applicationContext.getBean("address");
        System.out.println(stu);
        System.out.println(address);
    }
}
