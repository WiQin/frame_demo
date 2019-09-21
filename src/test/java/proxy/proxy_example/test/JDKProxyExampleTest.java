package proxy.proxy_example.test;

import proxy.proxy_example.JDKProxyExample;
import proxy.service.HelloWorld;
import proxy.service.impl.HelloWorldImpl;
import org.junit.Test;

public class JDKProxyExampleTest {

    @Test
    public void testJDKProxy(){
        JDKProxyExample jdk = new JDKProxyExample();
        HelloWorld proxy = (HelloWorld)jdk.bind(new HelloWorldImpl());
        proxy.sayHelloWorld();
    }

}
