package lesson3;
import java.util.*;

public class HomeWork {
    public static void main(String[] args){
        taskOne();

        PhoneBook.add(12341234, "Petrov");
        PhoneBook.add(1241534234, "Petrov");
        PhoneBook.add(141354234, "Sidorov");
        PhoneBook.add(12414234, "Kuznettsov");
        PhoneBook.add(145134234, "Petrov");
        PhoneBook.add(12134234, "Kuznettsov");

        PhoneBook.get("Kuznettsov");
        PhoneBook.get("Petrov");
        PhoneBook.get("Sidorov");

    }

    public static void taskOne(){
        List<String> list = new ArrayList<>();
        list.add("Three");
        list.add("Two");
        list.add("Five");
        list.add("Four");
        list.add("Seven");
        list.add("Two");
        list.add("Three");
        list.add("Six");
        list.add("Ten");
        list.add("One");
        list.add("Three");

        Set<String> uniqeList = new HashSet<>();

        for (String lists : list) {
            uniqeList.add(lists);
        }
        System.out.println(uniqeList);

        Map<String, Integer> mapOfUnique = new HashMap<>();

        for(int i = 0; i < list.size(); i++){
            if(!mapOfUnique.containsKey(list.get(i))){
                mapOfUnique.put(list.get(i), 1);
            } else {
                mapOfUnique.put(list.get(i), mapOfUnique.get(list.get(i)) + 1);
            }
        }

        System.out.println(mapOfUnique);


    }
}