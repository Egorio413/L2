package ru.university.lab2.numbers;

public class Task03BitwiseOps {
    public void run() {
        basics();
        shiftDiff();
        evenAndPower();
        countBitsDemo();
        swapXor();
    }

    private void basics() {
        System.out.println(" 1. Операторы ");
        int a = 0b1100;
        int b = 0b1010;
        System.out.println("a & b  = " + (a & b));
        System.out.println("a | b  = " + (a | b));
        System.out.println("a ^ b  = " + (a ^ b));
        System.out.println("~a     = " + (~a));
        System.out.println("a << 1 = " + (a << 1));
        System.out.println("a >> 1 = " + (a >> 1));
        System.out.println("a >>> 1= " + (a >>> 1));
    }

    private void shiftDiff() {
        System.out.println("\n 2. >> vs >>> ");
        int neg = -8;
        // >> сохраняет знаковый бит, >>> заполняет старшие биты нулями.
        System.out.println("-8 >> 1  = " + (neg >> 1));
        System.out.println("-8 >>> 1 = " + (neg >>> 1));
    }

    private void evenAndPower() {
        System.out.println("\n 3. Битовая проверка ");
        System.out.println("isEven(4) = " + isEven(4) + ", isEven(7) = " + isEven(7));
        System.out.println("isPowerOfTwo(8) = " + isPowerOfTwo(8) + ", isPowerOfTwo(10) = " + isPowerOfTwo(10));
    }

    private boolean isEven(int n) { return (n & 1) == 0; }
    private boolean isPowerOfTwo(int n) { return n > 0 && (n & (n - 1)) == 0; }

    private void countBitsDemo() {
        System.out.println("\n4. Подсчёт единиц ");
        System.out.println("bits(0b1011) = " + countBits(0b1011) + ", bits(255) = " + countBits(255));
    }

    private int countBits(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }

    private void swapXor() {
        System.out.println("\n5. Обмен через ^ ");
        int a = 5, b = 9;
        System.out.println("До:    a=" + a + ", b=" + b);
        a ^= b; b ^= a; a ^= b;
        System.out.println("После: a=" + a + ", b=" + b);
    }
}