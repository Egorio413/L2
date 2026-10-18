package ru.university.lab2.numbers;

public class Task01IntegerTraps {
    public void run() {
        printLimits();
        overflowInt();
        overflowLongVsInt();
        integerDivision();
        longToIntNarrowing();
        charArithmetic();
        overflowCheckDemo();
    }

    private void printLimits() {
        System.out.println(" 1. Границы ");
        System.out.println("byte:  " + Byte.MIN_VALUE + " .. " + Byte.MAX_VALUE);
        System.out.println("short: " + Short.MIN_VALUE + " .. " + Short.MAX_VALUE);
        System.out.println("int:   " + Integer.MIN_VALUE + " .. " + Integer.MAX_VALUE);
        System.out.println("long:  " + Long.MIN_VALUE + " .. " + Long.MAX_VALUE);
    }

    private void overflowInt() {
        System.out.println("\n 2. MAX_VALUE + 1 ");
        int max = Integer.MAX_VALUE;
        int overflowed = max + 1;
        // MAX_VALUE + 1 переполняется и превращается в MIN_VALUE.
        System.out.println("MAX + 1 = " + overflowed);
    }

    private void overflowLongVsInt() {
        System.out.println("\n 3. Умножение ");
        int intResult = Integer.MAX_VALUE * 2;
        long longResult = (long) Integer.MAX_VALUE * 2;
        // int обрезается до 32 бит и переполняется, long вмещает результат.
        System.out.println("int * 2  = " + intResult);
        System.out.println("long * 2 = " + longResult);
    }

    private void integerDivision() {
        System.out.println("\n 4. Деление ");
        System.out.println("5 / 2  = " + (5 / 2));
        System.out.println("-5 / 2 = " + (-5 / 2));
        // Знак остатка в Java совпадает со знаком ДЕЛИМОГО.
        System.out.println("5 % 2  = " + (5 % 2));
        System.out.println("-5 % 2 = " + (-5 % 2));
    }

    private void longToIntNarrowing() {
        System.out.println("\n 5. long -> int ");
        long big = Integer.MAX_VALUE + 10L;
        int narrowed = (int) big;
        System.out.println("long  = " + big + " -> (int) = " + narrowed);
    }

    private void charArithmetic() {
        System.out.println("\n 6. char арифметика ");
        char letter = 'A';
        char next = (char) (letter + 1);
        char sum = (char) ('A' + 'B');
        System.out.println("'A' + 1 = " + next + " (код " + (int) next + ")");
        System.out.println("'A' + 'B' = " + (int) sum + " (символ: " + sum + ")");
    }

    private void overflowCheckDemo() {
        System.out.println("\n7. Проверка переполнения ");
        System.out.println("MAX + 5: " + overflows(Integer.MAX_VALUE, 5));
        System.out.println("100 + 200: " + overflows(100, 200));
    }

    private boolean overflows(int a, int b) {
        int result = a + b;
        return (a > 0 && b > 0 && result < 0) || (a < 0 && b < 0 && result > 0);
    }
}