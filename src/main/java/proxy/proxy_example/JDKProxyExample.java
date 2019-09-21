package proxy.proxy_example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName JDKProxyExample
 * @Description: JDK动态代理
 * @Author: wangyw
 * @Date: 2019/9/10 19:22
 * @Version 1.0
 */
public class JDKProxyExample implements InvocationHandler {

    //真实对象
    private Object target = null;

    /**
     * 真实对象与代理对象的代理关系，并返回代理对象
     * 参数--类加载器，接口，定义实现方法逻辑的代理类
     * @param target  真实对象
     * @return  代理对象
     */
    public Object bind(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    /**
     * 代理方法逻辑
     * @param proxy  代理对象  bind方法生成的对象
     * @param method  当前调度方法
     * @param args  方法参数
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("进入代理逻辑方法");
        System.out.println("调用真实对象前服务");
        Object obj = method.invoke(target, args);//相当于调用接口方法
        System.out.println("调用真实对象后的服务");
        return obj;
    }
}
