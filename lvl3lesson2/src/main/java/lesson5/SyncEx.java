package lesson5;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SyncEx {
    public static void main(String[] args) {
 //       simpleLock();
 //       rwlEx();
       // countDownLatchEx();
        //cycleBarrirerEx();
        //barrierRunnableEx();

        //semophoreEx();

        //List<String> strings = new ArrayList<>();
        //List<String> strings = new Vector<>();
        //List<String> strings = new CopyOnWriteArrayList<>();
       // Set<String> stringSet = new HashSet<>();
        //Set<String> stringSet = new CopyOnWriteArraySet<>();    

    }

    private static void semophoreEx() {
        final Semaphore smp = new Semaphore(3);

        for (int i = 0; i < 10; i++) {
            final int count = i;
            new Thread(() -> {
                try{

                    System.out.println("Thread " + count + " before smp");
                    smp.acquire();
                    System.out.println("Thread " + count + " makeSomeLOngactions");
                    Thread.sleep((long)(200 * count + 500 + Math.random()));
                    System.out.println("Thread " + count + " end");
                } catch (InterruptedException e){
                    e.printStackTrace();
                } finally {
                    smp.release();
                }
            }).start();
        }
    }

    private static void barrierRunnableEx() {
        final int THREAD = 10;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(THREAD, () -> {
            System.out.println("Гонка началась");//действие будет выполненно, когда барьер отщелкает в  0
        });

        for (int i = 0; i < THREAD; i++) {
            int w = i;
            new Thread(() -> {
                try{
                    System.out.println("Racer " + w + " reading");
                    Thread.sleep((long)(200 * w + 500 + Math.random()));
                    System.out.println("Racer " + w + " ready in start line");
                    cyclicBarrier.await();
                    System.out.println("Racer " + w + " go");
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e){
                    e.printStackTrace();
                }
            }).start();
        }

//        try {
//            Thread.sleep(7000);
//            while (cyclicBarrier.getNumberWaiting() != THREAD){
//                Thread.sleep(300);
//            }
//            System.out.println("Start race");
//            cyclicBarrier.await();
//            while (cyclicBarrier.getNumberWaiting() != THREAD){
//                Thread.sleep(300);
//            }
//            System.out.println("Race end");
//            cyclicBarrier.await();
//        } catch (BrokenBarrierException | InterruptedException e){
//            e.printStackTrace();
//        }
    }

    private static void cycleBarrirerEx() {
        final int THREAD = 10;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(THREAD + 1);

        for (int i = 0; i < THREAD; i++) {
            int w = i;
            new Thread(() -> {
                try{
                    System.out.println("Racer " + w + " reading");
                    Thread.sleep((long)(200 * w + 500 + Math.random()));
                    System.out.println("Racer " + w + " ready in start line");
                    cyclicBarrier.await();
                    System.out.println("Racer " + w + " go");
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e){
                    e.printStackTrace();
                }
            }).start();
        }

        try {
//            Thread.sleep(7000);
            while (cyclicBarrier.getNumberWaiting() != THREAD){
                Thread.sleep(300);
            }
            System.out.println("Start race");
            cyclicBarrier.await();
            while (cyclicBarrier.getNumberWaiting() != THREAD){
                Thread.sleep(300);
            }
            System.out.println("Race end");
            cyclicBarrier.await();
        } catch (BrokenBarrierException | InterruptedException e){
            e.printStackTrace();
        }
    }

    private static void countDownLatchEx() {
        final int THREADS = 20;
        final CountDownLatch cdl = new CountDownLatch(4);

        System.out.println("Start!");
        for (int i = 0; i < THREADS; i++) {
            final int w = i;
            new Thread(() -> {
                try{
                    Thread.sleep((long)(200 * w + 500 + Math.random()));
                    System.out.println("Thread " + w + " ready");
                } catch (InterruptedException e){
                    e.printStackTrace();
                } finally {
                    cdl.countDown();
                }
            }).start();
        }

        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("End");
    }

    private static void rwlEx() {
        ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();// может отдельно блокировать операции чтения, и отдельно блокировать операции записи
        //потоки выполнябтся поочередно. читать может несколько потоков read. писать может только один, все остальные ставятся на паузу(и read и write)
        //когда какой-то из потоков приходит читать, другие тоже могут читать
        //когда какой-то из потоков приходит записывать, он становиться в очередь, пока другие читалки не сделают unlock
        //и когда после потока записи приходят другие потоки, они все встают в очередь, пока он не сдлелает unlock
        new Thread(() -> {

            try {
                rwl.readLock().lock();
                System.out.println("Read start lock 1");
                Thread.sleep(2000);
                System.out.println("READ lock 1");
            } catch (InterruptedException e){
                e.printStackTrace();
            } finally {
                System.out.println("End READLOCK 1");
                rwl.readLock().unlock();
            }
        }).start();

        new Thread(() -> {

            try {
                rwl.readLock().lock();
                System.out.println("Read start lock 2");
                Thread.sleep(2000);
                System.out.println("READ lock 2");
            } catch (InterruptedException e){
                e.printStackTrace();
            } finally {
                System.out.println("End READLOCK 2");
                rwl.readLock().unlock();
            }
        }).start();

        new Thread(() -> {
            try {
                rwl.readLock().lock();
                System.out.println("Read start lock 3");
                Thread.sleep(2000);
                System.out.println("READ lock 3");
            } catch (InterruptedException e){
                e.printStackTrace();
            } finally {
                System.out.println("End READLOCK 3");
                rwl.readLock().unlock();
            }
        }).start();

        new Thread(() -> {

            try {

                rwl.writeLock().lock();
                System.out.println("Write start lock 3");
                Thread.sleep(2000);
                System.out.println("Write lock 3");
            } catch (InterruptedException e){
                e.printStackTrace();
            } finally {
                System.out.println("end Write lock 3");
                rwl.writeLock().unlock();
            }
        }).start();

        new Thread(() -> {

            try {
                rwl.readLock().lock();
                System.out.println("Read start lock 4");
                Thread.sleep(2000);
                System.out.println("READ lock 4");
            } catch (InterruptedException e){
                e.printStackTrace();
            } finally {
                System.out.println("End READLOCK 4");
                rwl.readLock().unlock();
            }
        }).start();
    }

    private static void simpleLock() {
        final Lock lock = new ReentrantLock();

        new Thread(() -> {
            System.out.println("Before lock 1");
            try {
                lock.lock();
                System.out.println("Got lock 1");
                Thread.sleep(6000);
            } catch (InterruptedException e){
                e.printStackTrace();
            } finally {
                System.out.println("End lock 1");
                lock.unlock();
            }
        }).start();

//        new Thread(() -> {
//            System.out.println("Before lock 2");
//            try {
//                lock.lock();
//                System.out.println("Got lock 2");
//                Thread.sleep(7000);
//            } catch (InterruptedException e){
//                e.printStackTrace();
//            } finally {
//                System.out.println("End lock 2");
//                lock.unlock();
//            }
//        }).start();

        new Thread(() -> {
            System.out.println("Before lock 3");
            try {
                if (lock.tryLock(7, TimeUnit.SECONDS)) {//ждем 7 секунд, если за 7 секунд сможем занять, то занимаеи
                    try {
                        System.out.println("Got lock 3");
                        Thread.sleep(7000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        System.out.println("End lock 3");
                        lock.unlock();
                    }
                } else System.out.println("not now");
            } catch (InterruptedException e){
                e.printStackTrace();
            }

        }).start();
    }
}
