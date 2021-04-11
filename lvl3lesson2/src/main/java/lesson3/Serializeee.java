package lesson3;

import java.io.*;

public class Serializeee {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Cat c = new Cat("Barsik", "red");
        System.out.println(c);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("cat.ser"));
        oos.writeObject(c);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("cat.ser"));
        Cat fromFile = (Cat) ois.readObject();
        ois.close();
        System.out.println(fromFile);

    }
}
