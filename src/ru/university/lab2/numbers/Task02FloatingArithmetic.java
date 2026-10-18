package ru.university.lab2.numbers;

public class Task02FloatingArithmetic {
    public void run() {
        classicTrap();
        sumTenTimes();
        epsilonCompare();
        infAndNan();
        rounding();
        floatVsDouble();
    }

    private void classicTrap() {
        System.out.println("1. 0.1 + 0.2 ");
        double sum = 0.1 + 0.2;
        // 0.1 и 0.2 не представимы точно в двоичной системе.
        System.out.println("Сумма = " + sum + " == 0.3? " + (sum == 0.3));
    }

    private void sumTenTimes() {
        System.out.println("\n2. 0.1 × 10 ");
        double sum = 0.0;
        for (int i = 0; i < 10; i++) sum += 0.1;
        System.out.println("Сумма = " + sum + " == 1.0? " + (sum == 1.0));
    }

    private void epsilonCompare() {
        System.out.println("\n 3. Сравнение с epsilon ");
        double a = 0.1 + 0.2;
        double b = 0.3;
        System.out.println("Строго:  " + (a == b));
        System.out.println("С eps:   " + (Math.abs(a - b) < 1e-9));
    }

    private void infAndNan() {
        System.out.println("\n 4. Infinity и NaN ");
        System.out.println("1.0 / 0.0  = " + (1.0 / 0.0));
        System.out.println("-1.0 / 0.0 = " + (-1.0 / 0.0));
        double nan = 0.0 / 0.0;
        System.out.println("0.0 / 0.0  = " + nan + " | NaN == NaN: " + (nan == nan));
    }

    private void rounding() {
        System.out.println("\n 5. Округление ");
        double x = 2.7;
        System.out.println("(int) 2.7   = " + (int) x);
        System.out.println("round(2.7)  = " + Math.round(x));
        System.out.println("floor(2.7)  = " + Math.floor(x));
        System.out.println("ceil(2.7)   = " + Math.ceil(x));
        double y = -2.7;
        System.out.println("(int) -2.7  = " + (int) y);
        System.out.println("round(-2.7) = " + Math.round(y));
        System.out.println("floor(-2.7) = " + Math.floor(y));
        System.out.println("ceil(-2.7)  = " + Math.ceil(y));
    }

    private void floatVsDouble() {
        System.out.println("\n 6. float vs double ");
        float f = 0.1f + 0.2f;
        double d = 0.1 + 0.2;
        // float — 32 бита (≈7 цифр), double — 64 бита (≈15 цифр).
        System.out.println("float:  " + f + " | double: " + d);
    }
}