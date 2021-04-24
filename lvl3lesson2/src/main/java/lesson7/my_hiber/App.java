package lesson7.my_hiber;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        createTableReflect(Cat.class);
        createTableReflect(Worker.class);

        Cat c = new Cat(10, "<urzik", "Gray");
        addObjects(c);

        Worker w = new Worker(1, "sdfs", 55, 500 ,"sdfsdf", "fdsdf", "sdfs");
        addObjects(w);
    }

    private static void addObjects(Object o) {
        Connection conn = null;
        PreparedStatement ps = null;

        if (!o.getClass().isAnnotationPresent(Htable.class)) throw new RuntimeException("Unable to  insert obj");

        try{
            //insert into cats (id, name, text) values (...);
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:main.db");
            StringBuilder sb = new StringBuilder("insert into ");
            sb.append(((Htable)o.getClass().getAnnotation(Htable.class)).name());
            sb.append(" (");
            //insert into cats (
            Field[] fields = o.getClass().getDeclaredFields();
            for (Field field: fields){
                if(field.isAnnotationPresent(HField.class)) {
                    sb.append(field.getName()).append(", ");
                }
            }
            sb.setLength(sb.length() - 2);
            sb.append(") values (");
            //insert into cats (id, name, text) values (
            for (Field field: fields){
                if(field.isAnnotationPresent(HField.class)) {
                    sb.append("?, ");
                }
            }
            sb.setLength(sb.length() - 2);
            sb.append(");");
            ps = conn.prepareStatement(sb.toString());
            int n = 1;
            for (Field field: fields){
                if(field.isAnnotationPresent(HField.class)) {
                    ps.setObject(n++, field.get(o));
                }
            }
            //create table if not exists cats (id integer, name text, color text,

            ps.executeUpdate();

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (SQLException tr){
                tr.printStackTrace();
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException tr){
                tr.printStackTrace();
            }
        }
    }

    private static void createTableReflect(Class c) {
        Map<Class, String> typeMap = new HashMap<>();
        typeMap.put(int.class, "INTEGER");
        typeMap.put(String.class, "TEXT");

        Connection conn = null;
        Statement st = null;

        if (!c.isAnnotationPresent(Htable.class)) throw new RuntimeException("Unable to create");

        try{
            //create tabel cats (id integer, name text, color text)
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:main.db");
            st = conn.createStatement();
            StringBuilder sb = new StringBuilder("create table if not exists ");
            sb.append(((Htable)c.getAnnotation(Htable.class)).name());
            sb.append(" (");
            //create table if not exists cats (
            Field[] fields = c.getDeclaredFields();
            for (Field field: fields){
                if(field.isAnnotationPresent(HField.class)) {
                    sb.append(field.getName()).append(" ");
                    sb.append(typeMap.get(field.getClass())).append(", ");
                }
            }
            //create table if not exists cats (id integer, name text, color text,
            sb.setLength(sb.length() - 2);
            sb.append(");");
            st.executeUpdate(sb.toString());

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                if (st != null) st.close();
            } catch (SQLException tr){
                tr.printStackTrace();
            }
            try {
            if (conn != null) conn.close();
        } catch (SQLException tr){
            tr.printStackTrace();
        }
        }
    }
}
