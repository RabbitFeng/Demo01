package sync;

import java.util.concurrent.*;

public class Demo01 {

    private static int i = 0;

    public synchronized static void fun1() {
        System.out.println(i++);
    }

    public static void main(String[] args) {
        Callable<String> callable =new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "DONE";
            }
        };
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        Future<String> future = executorService.submit(callable);

        FutureTask<String> futureTask = new FutureTask<>(callable);

        Thread thread =  new Thread(futureTask);
    }
}
