package lesson6;

import java.util.ArrayList;

public class MainClass {


    public ArrayList<Integer> taskOne(ArrayList<Integer> arrayInt){
        ArrayList<Integer> resultArray = new ArrayList<>();
        int cnt = 0;
        for (int i = 0; i < arrayInt.size(); i++) {
            if (arrayInt.get(i) == 4){
                cnt++;
            }
        }

        if (cnt < 1){
            throw new RuntimeException();
        } else {
            int cntres = 0;
            for (int i = 0; i < arrayInt.size(); i++) {
                if (arrayInt.get(i) == 4){
                    cntres++;
                    if (cnt == cntres){

                        resultArray.addAll(arrayInt.subList(i + 1, arrayInt.size()));
                    }
                }
            }
        }

        return resultArray;
    }

    public boolean taskTwo(ArrayList<Integer> list){
        int cntOne = 0;
        int cntFour = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 1){
                cntOne++;
            } else if (list.get(i) == 4){
                cntFour++;
            }
        }

        return (cntFour > 0 || cntOne > 0);

    }
}



/*

2. Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
 Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов, идущих после последней четверки.
 Входной массив должен содержать хотя бы одну четверку, иначе в методе необходимо выбросить RuntimeException. Написать набор тестов для этого метода (по 3-4 варианта входных данных).
 Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
3. Написать метод, который проверяет состав массива из чисел 1 и 4. Если в нем нет хоть одной четверки или единицы, то метод вернет false;
 Написать набор тестов для этого метода (по 3-4 варианта входных данных).
 */