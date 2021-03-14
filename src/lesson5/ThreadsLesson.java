package lesson5;

public class ThreadsLesson {

    static final int size = 1000000;
    static final int h = size / 2;


    public static void main(String[] args) {
        float[] array = new float[size];
        arrayOne(array);
        arrayTwo(array);
    }

    public static void arrayOne(float[] array) {
        for (int i = 0; i < size; i++) {
            array[i] = 1;
        }

        long a = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.print("Время рассчета цикла первым методом ");
        System.out.println(System.currentTimeMillis() - a);
    }

    public static void arrayTwo(float[] array) {
        for (int i = 0; i < size; i++) {
            array[i] = 1;
        }

        float[] a1 = new float[h];
        float[] a2 = new float[h];

        long a = System.currentTimeMillis();
        System.arraycopy(array, 0, a1, 0, h);
        System.arraycopy(array, h, a2, 0, h);
        System.out.print("Время разбивки ");
        System.out.println(System.currentTimeMillis() - a);

        Runnable rn1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < a1.length; i++) {
                    a1[i] = (float) (a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        };

        Runnable rn2 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < a2.length; i++) {
                    a2[i] = (float) (a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        };

        Thread tr1 = new Thread(rn1);
        Thread tr2 = new Thread(rn2);

        a = System.currentTimeMillis();
        tr1.start();
        System.out.print("Просчет первого массива ");
        System.out.println(System.currentTimeMillis() - a);

        a = System.currentTimeMillis();
        tr2.start();
        System.out.print("Просчет второго массива ");
        System.out.println(System.currentTimeMillis() - a);

        a = System.currentTimeMillis();
        System.arraycopy(a1, 0, array, 0, h);
        System.arraycopy(a2, 0, array, h, h);
        System.out.print("Склейка ");
        System.out.println(System.currentTimeMillis() - a);

    }

}