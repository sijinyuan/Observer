package com.demo.demo;

/**
 * Created by Administrator on 2016/12/29.
 */
public class Client {
    private static ConcreteSubject subject;
    private static Observer observer;

    public static void main(String[] args) {
        //创建目标对象
        subject=new ConcreteSubject();
        //创建一个观察者对象
        observer=new ConcreteObserver();
        subject.attch(observer);
        subject.change("mythou has changed date!");
    }


}
