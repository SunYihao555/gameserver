package com.mt.remoting;

import com.mt.remoting.protocol.ProtocolFactory;

import java.util.Vector;

public class Test02 {
    public static void main(String[] args) {
        Vector<student> vector = new Vector();
        student studenta = new student();
        studenta.setName("xiaoming");
        student studentb = new student();
        studentb.setName("xiaohong");

        vector.add(studenta);
        vector.add(studentb);
        new Thread(new Runnable() {
            @Override
            public void run() {
                    while (true) {
                        for (student o : vector) {
                            System.out.println(o.getName());
                        }
                    }

            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                studenta.setName("小红");
                studentb.setName("小刚");


            }
        }).start();
//        System.out.println(ProtocolFactory.protocolMap);

    }
}
class student{
    String name;

    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}
