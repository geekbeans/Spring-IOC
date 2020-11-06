package com.czhspringreview.factory;

import com.czhspringreview.entity.Car;

import java.util.HashMap;
import java.util.Map;

public class InstanceFactory {
    private Map<Long, Car> carMap;
    //无参构造
    public InstanceFactory(){
        carMap = new HashMap<>();
        carMap.put(3L,new Car(3L,"保时捷"));
        carMap.put(4L,new Car(4L,"法拉利"));
    }
    //实例工厂方法
    public Car getCar(long id){
        return carMap.get(id);
    }
}
