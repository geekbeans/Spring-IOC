package com.czhspringreview;

import com.czhspringreview.entity.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIocAutowireTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring_autowire.xml");
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);
    }
}
