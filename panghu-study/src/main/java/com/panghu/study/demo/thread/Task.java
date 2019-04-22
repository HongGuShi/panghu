package com.panghu.study.demo.thread;

public class Task implements Runnable {
    private String one;
    private int count;
    private Conn con;

    public Task() {
    }

    public Task(String one, int count, Conn con) {
        this.one = one;
        this.count = count;
        this.con = con;
    }

    @Override
    public void run() {
        int i = 0;
        while (i < 10) {
            synchronized (Task.class) {
                if (con.num % 3 == count) {
                    con.num++;
                    System.out.println(one + ":---:" + con.num + ":---:" + i);
                } else {
                    continue;
                }
            }
            i++;
        }
    }
}
