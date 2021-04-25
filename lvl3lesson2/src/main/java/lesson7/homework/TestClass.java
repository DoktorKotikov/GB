package lesson7.homework;

public class TestClass {
    public static void method1() {
        System.out.println("method 1");
    }

    @BeforeSuite
    public static void start() {
        System.out.println("Start");
    }

    @Test(priority = 4)
    public static void method2(){
        System.out.println("method 2");
    }

    @Test(priority = 3)
    public static void method3(){
        System.out.println("method 3");
    }

    @Test(priority = 2)
    public static void method4(){
        System.out.println("method 4");
    }

    @AfterSuite
    public static void shutdown(){
        System.out.println("Shutdown");
    }

}
