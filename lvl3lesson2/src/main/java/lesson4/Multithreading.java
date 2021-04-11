package lesson4;

import javax.swing.*;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

public class Multithreading {
    static int a = 0;
    static int b = 0;
    static int c = 0;
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

//        Thread.getAllStackTraces().forEach((k, v) -> System.out.println(k + " " + v));

//        Thread t = new Thread();
//
//        Thread tAnonim = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("hello from anonymous");
//            }
//        });
//
//        Thread tLambda = new Thread(() -> System.out.println("hello from lambda with link"));
//
//        new Thread(() -> System.out.println("Hello from lambda")).start();//тоже лямбда но без ссылки


        //ExecutorService service = Executors.newSingleThreadExecutor();
//        ExecutorService service = Executors.newFixedThreadPool(4);
//        for (int i = 0; i < 10; i++) {
//            int w = i + 1;
//            service.execute(() ->{
//                System.out.println(w + " -start!");
//                try {
//                    Thread.sleep((long) (2000 + 2000*Math.random()));
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(w + "- finished!");
//            });
//        }
//        //service.execute(() -> System.out.println("Ex runnable!"));
//        service.shutdown();

//        ExecutorService service = Executors.newCachedThreadPool();
//
//        for (int i = 0; i < 10; i++) {
//            int w = i + 1;
//            service.execute(() ->{
//                System.out.println(w + " -start!");
//                try {
//                    Thread.sleep((long) (2000 + 2000*Math.random()));
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(w + "- finished!");
//            });
//        }
//        //service.execute(() -> System.out.println("Ex runnable!"));
//        service.shutdown();

//        ExecutorService service = Executors.newCachedThreadPool(new ThreadFactory() {
//            @Override
//            public Thread newThread(Runnable r) {
//                Thread t = new Thread(r);
//                t.setName("My Thread");
//                return t;
//            }
//        });
//
//        for (int i = 0; i < 10; i++) {
//            int w = i + 1;
//            service.execute(() ->{
//                System.out.println(w + " -start! Name: " + Thread.currentThread().getName());
//                try {
//                    Thread.sleep((long) (2000 + 2000*Math.random()));
// //                   Thread.yield();//отдать свое процессорное время
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(w + "- finished!");
//            });
//        }
//        //service.execute(() -> System.out.println("Ex runnable!"));
//        service.shutdown();
//        ExecutorService service1 = Executors.newFixedThreadPool(4);
//
//        Future<String> future = service1.submit(new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                Thread.sleep(10_000);
//                return "Some String from Callable";
//            }
//        });
//
//        System.out.println(future.get(5, TimeUnit.SECONDS));
//        service1.shutdown();

//        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                Thread.sleep(1000);
//                return "Future task";
//            }
//        });
//
//        new Thread(futureTask).start();
//
//        System.out.println(futureTask.get());

//
//        Thread t = new Thread(() -> {
//           while(!Thread.currentThread().isInterrupted()){
//               try {
//                   System.out.println("tick");
//                   Thread.sleep(200);
//                   System.out.println("tock");
//                   Thread.sleep(200);
//               } catch (InterruptedException e) {
//                   e.printStackTrace();
//               }
//           }
//        });
//        t.start();
//        Thread.sleep(2000);
//        t.interrupt();
//        t.suspend();
//        t.resume();
//        t.stop();
//        Timer timer = new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                System.out.println("Times up!");
//            }
//        }, 10000);
//        Thread t1 = new Thread(() ->{
//            for (int i = 0; i < 1000; i++) {
//                increment();
//            }
//        });
//        Thread t2 = new Thread(() ->{
//            for (int i = 0; i < 1000; i++) {
//                increment();
//            }
//        });
//        Thread t3 = new Thread(() ->{
//            for (int i = 0; i < 1000; i++) {
//                increment();
//            }
//        });
//
//        t1.start();
//        t1.join();
//        t2.start();
//        t2.join();
//        t3.start();
//
//
//
//        t3.join();
//        System.out.printf("a = %d, b = %d, c = %d", a, b, c);
//
  }
//
//    static void increment() {
//        a++;
//        b++;
//        c++;
//    }




}
