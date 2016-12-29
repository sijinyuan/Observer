package com.demo.demo;

import java.util.Observer;

/**
 * Created by Administrator on 2016/12/29.
 */
//目标对象接口
public interface Subject {
     //调用这个方法注册一个新的观察者模式
    public void attch(Observer observer);

    //调用这个方法删除一个已注册的观察者对象

    public void detach(Observer observer);

    //调用这个方法通知所有注册的观察者模式

    void notifObservers();

}
