package com.example.springapp.demo2;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyCglibProxy implements MethodInterceptor {
    private ProductDao dao;
    public MyCglibProxy(ProductDao dao){
        this.dao=dao;
    }
    public Object createProxy(){
        //1.创建核心类
        Enhancer enhancer=new Enhancer();
//        2.设置父类
        enhancer.setSuperclass(dao.getClass());
//        3.设置回调
        enhancer.setCallback((Callback) this);
//        4.返回生成代理
        return enhancer.create();
    }
    @Override
    public Object intercept(Object proxy, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if ("save".equals(method.getName())) {
            System.out.println("权限校验......");
            return methodProxy.invokeSuper(proxy, objects);
        }
        return methodProxy.invokeSuper(proxy, objects);
    }
    /*
*@pram proxy CGLIB根据指定的父类生成的代理对象
*@pram method  拦截方法
*@pram args  拦截方法的参数数组
*@pram methodProxy 方法的代理对象，用于执行父类的方法
 *@return 代理后的对象
 */
//    @Override
//    public Object invoke(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
//        //创建切面对象
//    }
}
