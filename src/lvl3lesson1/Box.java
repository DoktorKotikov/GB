package lvl3lesson1;


import java.util.ArrayList;
import java.util.Collection;

public class Box<F>{
    private ArrayList<F> fruits = new ArrayList<>();

    public Box(){

    }

    public void setFruit(F fruit){
        fruits.add(fruit);
    }

    public float getWeight(){
        return (fruits.get(0) instanceof Apple) ? 1.0f * (fruits.size()) : 1.5f * (fruits.size());
    }

    public boolean compare(Box<?> box){
        return (this.getWeight() == box.getWeight());
    }

    public void swap(Box<F> box){
        ArrayList<F> tmp = new ArrayList<>(this.fruits);
        this.fruits.clear();
        this.fruits.addAll(box.fruits);
        box.fruits.clear();
        box.fruits.addAll(tmp);
    }

    public void printBox(){
        for(F fruit : fruits){
            System.out.print(fruit + " ");
        }
        System.out.println();
    }
}
