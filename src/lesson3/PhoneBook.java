package lesson3;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {


    private static Map<Integer, String> map = new HashMap<>();

    public static void add(int phone, String surname){
        map.put(phone, surname);
    }

    public static void get(String surname){
        for(Map.Entry<Integer, String> phone : map.entrySet()){
            if (phone.getValue().equals(surname)) {
                System.out.println(surname + ' ' + phone.getKey());
            }
        }
    }
}
