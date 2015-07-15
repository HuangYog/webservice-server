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

/*

java -cp axis.jar;axis-ant.jar;commons-discovery-0.2.jar;
commons-logging-1.0.4.jar;jaxrpc.jar;log4j-1.2.8.jar;saaj.jar;
wsdl4j-1.5.1.jar;xercesImpl-2.8.1.jar
org.apache.axis.client.AdminClient  -lhttp://localhost:8888/server/services/AdminService deploy.wsdd

 */