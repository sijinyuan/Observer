package com.demo.demo;

/**
 * Created by Administrator on 2016/12/29.
 */
public class ConcreteObserver implements Observer {


    @Override
    public void update() {
        System.out.println("The subject has changed！ mythou notify");
    }
}
