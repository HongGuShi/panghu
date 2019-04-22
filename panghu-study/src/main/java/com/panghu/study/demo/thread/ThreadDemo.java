package com.panghu.study.demo.thread;


/**
 * 实现多个线程顺序打印ABC
 */
public class ThreadDemo {
    public static void main(String[] args) {
        Conn con = new Conn();
        Thread a = new Thread(new Task("A", 0, con));
        Thread b = new Thread(new Task("B", 1, con));
        Thread c = new Thread(new Task("C", 2, con));
        c.start();
        b.start();
        a.start();
    }
}


