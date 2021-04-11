package lesson5.homework;

public class Road extends Stage{
    public Road(int length) {
        this.length = length;
        this.description = "Дорога " + length + " метров";
    }
    @Override
    public void go(Car c) {

        try {
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
            System.out.println(c.getName() + " закончил этап: " + description);
            if (length == 40){
                MainClass.cdl2.countDown();
                if(MainClass.cdl2.getCount() == 4){
                    System.out.println( c.getName() +"  - WIN");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


}
