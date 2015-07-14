package com.test.obj;

import org.apache.axis.Constants;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 * Created by HY on 2015/7/14.
 * desc:
 */
public class TestService {

    private static final Log log = LogFactory.getLog(TestService.class);
    private static final String HELLO_SERVICE_ENDPOINT = "http://localhost:8888/server/services/HelloServices?wsdl";

    /**
     * 调用sayHello方法
     */
    public void callSayHello() {
        try {
            Service service = new Service();
            Call call = (Call) service.createCall();
            //传递url
            call.setTargetEndpointAddress(new java.net.URL(HELLO_SERVICE_ENDPOINT));
            //调用方法名字
            call.setOperationName(new QName("http://webservice.sinosoft.com/","sayHello"));
            call.addParameter("tiger", org.apache.axis.Constants.XSD_STRING, javax.xml.rpc.ParameterMode.IN);
            call.setReturnType(org.apache.axis.Constants.XSD_STRING);
            try {
                //ret即执行方法之后得到的返回值，此处不用传参，故不用写字符串
                String ret = (String) call.invoke(new Object[] {"HY"});
                System.out.println("The return value is:" + ret);
                return;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        log.error("call sayHello service error!");
    }

    /**
     * 调用sayHelloToPerson方法
     */
    public void callSayHelloToPerson() {
        try {
            Service service = new Service();
            Call call = (Call) service.createCall();
            call.setTargetEndpointAddress(new java.net.URL(HELLO_SERVICE_ENDPOINT));
            call.setOperationName(new QName("http://webservice.sinosoft.com/", "sayHelloToPerson"));
            call.addParameter("nameAA", org.apache.axis.Constants.XSD_STRING, javax.xml.rpc.ParameterMode.IN);
            call.addParameter("age", Constants.XSD_INT, javax.xml.rpc.ParameterMode.IN); //参数类型
            call.setReturnType(org.apache.axis.Constants.XSD_STRING);//返回值类型
            try {
                //ret即执行方法之后得到的返回值，此处传了一个字符串做为参数，如果不写空，会报错
                String ret = (String) call.invoke(new Object[] {"Seven",18});
                System.out.println("The return value is:" + ret);
                return;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        log.error("call sayHello service error!");
    }

    /**
     * 调用两个方法
     * @param args
     */
    public static void main(String[] args) {
        TestService tester = new TestService();
        tester.callSayHello();
        tester.callSayHelloToPerson();
    }


}
