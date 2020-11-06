package com.czhspringreview.factory;

import com.czhspringreview.entity.Car;

import java.util.HashMap;
import java.util.Map;

public class StaticFactory {
    private static Map<Long,Car> carMap;
    //静态代码块
    static {
        carMap = new HashMap<>();
        carMap.put(1L,new Car(1L,"奔驰"));
        carMap.put(2L,new Car(2L,"宝马"));
    }
    //静态方法
    public static Car getCar(long id){
        return carMap.get(id);
    }
}
