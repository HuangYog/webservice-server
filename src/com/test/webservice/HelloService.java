package com.test.webservice;

/**
 * Created by HY on 2015/7/14.
 * desc:
 */
public class HelloService {
    public String sayHello(String tiger) {
        return "hello: " + tiger;
    }

    public String sayHelloToPerson(String nameAA,int age){
        if(nameAA == "" || nameAA.equals("")){
            nameAA = "nobody";
        }
        return "hello " + nameAA + "_ Age:" +age;
    }
}

