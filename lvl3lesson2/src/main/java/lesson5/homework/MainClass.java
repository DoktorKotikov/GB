package lesson5.homework;

import java.util.concurrent.CountDownLatch;


public class MainClass {
    public static final int CARS_COUNT = 4;
    public static CountDownLatch cdl = new CountDownLatch(CARS_COUNT + 1);
    public static CountDownLatch cdl2 = new CountDownLatch(CARS_COUNT + 1);
    public static void main(String[] args) throws InterruptedException {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));

        }

        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }

        while(true){
            if(cdl.getCount() == 1){
                cdl.countDown();
                System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
                break;
            }
        }


        while(true){
            if(cdl2.getCount() == 1){
                cdl2.countDown();
                System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
                break;
            }
        }





    }
}
