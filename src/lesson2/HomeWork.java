package lesson2;

public class HomeWork {
    public static void main(String[] args) {
        String[][] list = {{"1", "2", "3", "5"}, {"2", "5", "9", "10"} ,{"5", "f", "9", "20",}, {"1", "5", "7", "2"}};
        try {
            System.out.println(sumInt(list));
        } catch (MyArraySizeException | MyArrayDataException e){

        }


    }

    private static int sumInt(String[][] strings) throws MyArraySizeException, MyArrayDataException {
        int result = 0;
        if(strings[0].length > 4){
            throw new MyArraySizeException();
        } else {
            for(int i = 0; i < strings[0].length; i++){
                for(int j = 0; j < strings[0].length; j++){
                    try {
                        result += Integer.parseInt(strings[i][j]);
                    } catch (NumberFormatException e){
                        throw new MyArrayDataException(i, j);
                    }
                }
            }

        }


        return result;
    }

    public static class MyArrayDataException extends Exception {
        public MyArrayDataException(int i, int j) {
            System.out.println("Неверные данные в ячейек " + i + ";" + j);
        }

    }

    public static class MyArraySizeException extends Exception{
        public MyArraySizeException(){
            System.out.println("Массив больше 4-х");
        }
    }
}
