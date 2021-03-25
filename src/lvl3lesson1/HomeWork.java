package lvl3lesson1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeWork {
    public static void main(String[] args) {
        taskOne();
        taskTwo();
        taskThree();
    }

    public static void swapTwoElements(List<Object> list){
        Object tmp = list.get(0);
        list.set(0, list.get(1));
        list.set(1, tmp);
    }

    public static void taskOne(){
        List<Object> arr = new ArrayList<>();
        arr.add("String");
        arr.add(2);
        System.out.println(arr);
        swapTwoElements(arr);
        System.out.println(arr);
    }

    public static void taskTwo(){
        String[] st = {"1", "2", "3", "4", "5"};
        System.out.println(st.getClass().getSimpleName());
        ArrayList<Object> arrayList = makeArrayList(st);
        System.out.println(arrayList.getClass().getSimpleName());
    }

    public static ArrayList<Object> makeArrayList(Object[] array){
        ArrayList<Object> arrayList = new ArrayList<>();
        for(int i = 0; i < array.length; i++){
            arrayList.add(array[i]);
        }
        return arrayList;
    }

    public static void taskThree(){
        Apple apple = new Apple();
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Box<Apple> appleBox = new Box<>();
        appleBox.setFruit(apple);
        appleBox.setFruit(apple1);
        appleBox.setFruit(apple2);
        System.out.println(appleBox.getWeight());

        Orange orange = new Orange();
        Orange orange1 = new Orange();
        Box<Orange> orangeBox = new Box<>();
        orangeBox.setFruit(orange);
        orangeBox.setFruit(orange1);
        System.out.println(orangeBox.getWeight());
        //Сравнение наполнения по весу
        System.out.println(orangeBox.compare(appleBox));
        //Пересыпка из коробки в коробку
        Orange orange2 = new Orange();
        Orange orange3 = new Orange();
        Box<Orange> orangeBox1 = new Box<>();
        orangeBox1.setFruit(orange2);
        orangeBox1.setFruit(orange3);
        orangeBox.printBox();
        orangeBox1.printBox();
        orangeBox1.swap(orangeBox);
        orangeBox.printBox();
        orangeBox1.printBox();

    }
}
