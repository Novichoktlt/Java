package lesson2_5.online;

import java.util.Arrays;

public class Array {

    static final int SIZE = 10000000;
    static final int H = SIZE / 2;


    public static void main(String[] args) {

        float[] arr = new float[SIZE];
        float[] arrD = new float[SIZE];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;

        }
        for (int i = 0; i < arrD.length; i++) {
            arrD[i] = i + 1;

        }

        usual(arr);
        divided(arrD, H);
        if (Arrays.equals(arr, arrD)){
            System.out.println("Массивы равны");
        }else {
            System.out.println("Массивы не равны");
        }
    }

    public static void formula(float[] arr, int bias){
        for (int i = 0; i < arr.length; i++) {

            arr[i] = (float)(arr[i] * Math.sin(0.2f + (i + bias)/ 5) * Math.cos(0.2f + (i + bias) / 5) * Math.cos(0.4f + (i + bias) / 2));

        }

    }

    public static void usual(float[] arr){

        long start = System.currentTimeMillis();

        formula(arr, 0);
        long finish = System.currentTimeMillis();
        long tame = finish - start;
        System.out.println("Время обработки массива одним потоком: " + tame);
    }

    public static void divided(float[] arr, int H){



        long start = System.currentTimeMillis();
        float[] arr1 = new float[H];
        float[] arr2 = new float[H];

        System.arraycopy(arr, 0, arr1, 0, H);
        System.arraycopy(arr, H, arr2, 0, H);


        Thread t1 = new Thread(() -> formula(arr1, 0));
        Thread t2 = new Thread(() -> formula(arr2, H));
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.arraycopy(arr1, 0, arr, 0, H);
        System.arraycopy(arr2, 0, arr, H, H);

        long finish = System.currentTimeMillis();
        long tame = finish - start;
        System.out.println("Время обработки массива двумя потоками: " + tame);

    }


}
