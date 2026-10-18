package ru.university.lab2.util;

public class Task07Methods {
    public void run() {
        overloadDemo();
        varargsDemo();
        powerDemo();
    }

    private void overloadDemo() {
        System.out.println(" 1. Перегрузка print ");
        print(42); print(3.14); print("Строка"); print(new int[]{1, 2, 3});
    }

    public void print(int x)     { System.out.println("int: " + x); }
    public void print(double x)  { System.out.println("double: " + x); }
    public void print(String s)  { System.out.println("String: " + s); }
    public void print(int[] a) {
        System.out.print("int[]: [");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            if (i < a.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    private void varargsDemo() {
        System.out.println("\n 2. varargs ");
        System.out.println("sum() = " + sum());
        System.out.println("sum(1,2,3) = " + sum(1, 2, 3));
        System.out.println("sum(new int[]{10,20,30}) = " + sum(new int[]{10, 20, 30}));
    }

    public int sum(int... arr) {
        int s = 0;
        for (int x : arr) s += x;
        return s;
    }

    private void powerDemo() {
        System.out.println("\n 3. Степень ");
        for (int base = 2; base <= 3; base++)
            for (int exp = 0; exp <= 5; exp++)
                System.out.printf("%d^%d = рекурсия %d, итерация %d, Math.pow %.0f%n",
                        base, exp, recursivePower(base, exp), iterativePower(base, exp), Math.pow(base, exp));
        // Итерация быстрее, так как нет накладных расходов на создание фреймов стека.
    }

    public int recursivePower(int base, int exp) {
        if (exp == 0) return 1;
        return base * recursivePower(base, exp - 1);
    }

    public int iterativePower(int base, int exp) {
        int r = 1;
        for (int i = 0; i < exp; i++) r *= base;
        return r;
    }
}