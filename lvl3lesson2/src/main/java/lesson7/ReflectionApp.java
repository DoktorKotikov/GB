package lesson7;


import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.Arrays;

public class ReflectionApp {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
//        Class stringClass = "Some string".getClass();
//        Class stringClass1 = String.class;
//        Class jdbc = Class.forName("org.sqlite.jdbc");
//        Class c = Cat.class;
//        int mods = c.getModifiers();
//        if (Modifier.isStatic(mods)) System.out.println("Static");
//        if (Modifier.isPublic(mods)) System.out.println("Public");
//        if (Modifier.isFinal(mods)) System.out.println("Final");
//        Field[] fields = c.getFields();
//        for (Field field: fields
//             ) {
//            System.out.println(field);
//        }

//        System.out.println(int.class);
//        System.out.println(int[].class);
//        System.out.println(int[][].class);
//        System.out.println(void.class);
        Cat cat = new Cat("Barsik", "green", 5);
//        Class c = cat.getClass();
//        Constructor[] constructors = c.getConstructors();
//        for (Constructor constuctor: constructors
//             ) {
//            System.out.println(constuctor);
//        }
//        Constructor cons = c.getConstructor(new Class[] {String.class, String.class, int.class});
//        Cat reflCat = (Cat) cons.newInstance("Reflector", "black", 99);
//        System.out.println(reflCat);
//        c.getInterfaces();
//        c.getSuperclass();
//        Field[] fields = c.getDeclaredFields();
//        System.out.println(Arrays.toString(fields));
//
//        Field b = c.getDeclaredField("bowl");
//        System.out.println(b);

//        Field f = c.getDeclaredField("name");
//        f.setAccessible(true);
//        f.set(cat, "Murzik");
//        System.out.println(f.get(cat));
//        Field[] fields = c.getDeclaredFields();
//        for (Field field: fields
//             ) {
//            System.out.println(field);
//        }
        //cat.getClass().getDeclaredMethods();
//        Method voice = cat.getClass().getDeclaredMethod("voice");
//        Method run = cat.getClass().getDeclaredMethod("run", int.class);
//        voice.setAccessible(true);
//        run.setAccessible(true);
//
//        run.invoke(cat, 10);
        for (Annotation a : cat.getClass().getDeclaredMethod("voice").getDeclaredAnnotations()){
            System.out.println(((MyAnnoctation) a).sValue() + " " + ((MyAnnoctation) a).value());
        }

    }
    @MyAnnoctation
    static class Cat {
        private String name;
        public String color;
        int age;
        private Bowl bowl;

        public Cat(String name, String color, int age) {
            this.name = name;
            this.color = color;
            this.age = age;
        }
        @MyAnnoctation(value = 155, sValue = "sdfsf")
        void voice(){
            System.out.println(name + " meow");
        }
        public void run(int distance){
            System.out.println(name + " running for " + distance);
        }

        @Override
        public String toString() {
            return "Cat{" +
                    "name='" + name + '\'' +
                    ", color='" + color + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    static class Bowl {
        int food;
    }
}
