package ru.university.lab2.arrays;

import java.util.Random;

public class Task05Arrays {
    public void run() {
        int[] numbers = createRandomArray(10, 1, 100);
        System.out.println("Массив: " + arrayToString(numbers));
        printMinMaxAverage(numbers);
        sortAndPrint(numbers);
        equalityDemo();
    }

    private int[] createRandomArray(int size, int min, int max) {
        int[] arr = new int[size];
        Random r = new Random();
        for (int i = 0; i < size; i++) arr[i] = r.nextInt(max - min + 1) + min;
        return arr;
    }

    private void printMinMaxAverage(int[] arr) {
        int min = arr[0], max = arr[0];
        double sum = 0;
        for (int x : arr) {
            if (x < min) min = x;
            if (x > max) max = x;
            sum += x;
        }
        System.out.println("\nМин: " + min + ", Макс: " + max + ", Среднее: " + (sum / arr.length));
    }

    private void sortAndPrint(int[] arr) {
        int[] copy = copyOf(arr);
        System.out.println("\nПузырёк ");
        System.out.println("До:    " + arrayToString(copy));
        for (int i = 0; i < copy.length - 1; i++)
            for (int j = 0; j < copy.length - 1 - i; j++)
                if (copy[j] > copy[j + 1]) {
                    int t = copy[j];
                    copy[j] = copy[j + 1];
                    copy[j + 1] = t;
                }
        System.out.println("После: " + arrayToString(copy));
    }

    private void equalityDemo() {
        System.out.println("\n == vs equals vs Arrays.equals ");
        int[] a = {1, 2, 3};
        int[] b = {1, 2, 3};
        System.out.println("a == b             : " + (a == b));
        System.out.println("a.equals(b)        : " + a.equals(b));
        System.out.println("Arrays.equals(a, b): " + java.util.Arrays.equals(a, b));
    }

    private int[] copyOf(int[] src) {
        int[] copy = new int[src.length];
        for (int i = 0; i < src.length; i++) copy[i] = src[i];
        return copy;
    }

    private String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) sb.append(", ");
        }
        return sb.append("]").toString();
    }
}