package com.ssm.chapter02.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectServiceImpl2 {
    private String name;

    public ReflectServiceImpl2(String name) {
        this.name = name;
    }

    public void sayHello(){
        System.err.println("Hello"+name);
    }

    /**
     * 通过反射生成带有参数的构建方法
     * @return
     */
    public ReflectServiceImpl2 getInstance(){
        ReflectServiceImpl2 object = null;

        try {
            //object = new ReflectServiceImpl2("张三");   反射方式
            object = (ReflectServiceImpl2) Class.forName("com.ssm.chapter02.reflect.ReflectServiceImpl2").getConstructor(String.class).newInstance("张三");
        } catch (ClassNotFoundException | InvocationTargetException | NoSuchMethodException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return object;
    }
}
