package com.ssm.chapter02.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectServiceImpl {
    public void sayHello(String name){
        System.err.println("Hello"+name);
    }

    /**
     * 反射生成对象
     * @return
     */
    public ReflectServiceImpl getInstance(){
        ReflectServiceImpl object = null;

        try {
            object = (ReflectServiceImpl) Class.forName("com.ssm.chapter02.reflect.ReflectServiceImpl").newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }

    /**
     * 获取和反射方法
     * @return
     */
    public Object reflectMethod(){
        Object returnObject = null;
        ReflectServiceImpl tartget = new ReflectServiceImpl();

        try {
            Method method =  ReflectServiceImpl.class.getMethod("sayHello",String.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return returnObject;
    }

    /**
     * f反射生成对象  反射调用方法
     * @return
     */
    public Object reflect(){
        ReflectServiceImpl object = null;
        try {
            object = (ReflectServiceImpl)Class.forName("com.ssm.chapter02.reflect.ReflectServiceImpl").newInstance();
            Method method =  ReflectServiceImpl.class.getMethod("sayHello",String.class);
            method.invoke(object,"张三");
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return object;
    }
}
