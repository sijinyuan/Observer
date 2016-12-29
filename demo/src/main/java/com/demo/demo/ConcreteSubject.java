package com.demo.demo;

import java.util.Enumeration;
import java.util.Observer;
import java.util.Vector;

/**
 * Created by Administrator on 2016/12/29.
 */
//目标对象实现
public class ConcreteSubject implements Subject {

//向里容器，保存所有注册的观察者
    private Vector observersVector=new Vector();
    @Override
    public void attch(Observer observer) {
        observersVector.addElement(observer);
    }

    @Override
    public void detach(Observer observer) {
        observersVector.removeElement(observer);
    }

    @Override
    public void notifObservers() {
        Enumeration enumeration=observers();
        while(enumeration.hasMoreElements()){
            ((Observer)enumeration.nextElement()).update();
        }
    }


}
