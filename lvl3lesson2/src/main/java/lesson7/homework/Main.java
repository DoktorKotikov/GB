package lesson7.homework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main (String[] args) throws InvocationTargetException, IllegalAccessException {
        start(TestClass.class);
    }


    public static void start(Class c) throws InvocationTargetException, IllegalAccessError, IllegalAccessException {
        Method[] methods = c.getDeclaredMethods();
        List<Method> list = new ArrayList<>();
        for (Method m : methods) {
            if(m.isAnnotationPresent(Test.class)) {
                int pr = m.getAnnotation(Test.class).priority();
                if (pr < 1 || pr > 10) throw new RuntimeException("Prio exception");
                list.add(m);
            }
        }

        list.sort(new Comparator<Method>() {
            @Override
            public int compare(Method o1, Method o2) {
                return o2.getAnnotation(Test.class).priority() - o1.getAnnotation(Test.class).priority();
            }
        });

        for (Method m : methods){
            if(m.isAnnotationPresent(BeforeSuite.class)) {
                if(list.get(0).isAnnotationPresent(BeforeSuite.class))
                    throw new RuntimeException("Before suite exception");
                list.add(0, m);
            }

            if (m.isAnnotationPresent(AfterSuite.class)) {
                if(list.get(list.size() - 1).isAnnotationPresent(AfterSuite.class))
                    throw new RuntimeException("After suite exception");
                list.add(m);
            }
        }

        for (Method m : list) {
            m.invoke(null);
        }

    }


}
