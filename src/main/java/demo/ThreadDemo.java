package demo;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadDemo {
    private int steps;

    public synchronized void over(int i) {
        to(steps + i);
    }

    public void to(int to) {
        steps = to;
        System.out.println(to);
    }

    public void runOnThread(final int i) {
        new Thread(() -> {
            over(i);
        }).start();
    }

    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        for (int i = 0; i < 100; i++) {
            threadDemo.runOnThread(1);
        }
    }
}
