package ru.university.lab2.util;

import ru.university.lab2.numbers.*;
import ru.university.lab2.strings.Task04TextProcessing;
import ru.university.lab2.arrays.*;
import java.util.Scanner;

public class Task08Menu {
    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        do {
            printMenu();
            if (!scanner.hasNextInt()) {
                scanner.next();
                System.out.println("Ошибка: введите число.");
                continue;
            }
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> new Task01IntegerTraps().run();
                case 2 -> new Task02FloatingArithmetic().run();
                case 3 -> new Task03BitwiseOps().run();
                case 4 -> new Task04TextProcessing().run();
                case 5 -> new Task05Arrays().run();
                case 6 -> new Task06Matrix().run();
                case 7 -> new Task07Methods().run();
                case 0 -> System.out.println("Выход.");
                default -> System.out.println("Нет такого пункта.");
            }
        } while (choice != 0);
    }
    private void printMenu() {
        System.out.println("""
                
                 МЕНЮ 
                1 — Целочисленные ловушки
                2 — Вещественная арифметика
                3 — Побитовые операции
                4 — Обработка текста
                5 — Одномерные массивы
                6 — Многомерные массивы
                7 — Методы и аргументы
                0 — Выход
                
                Ваш выбор: """);
    }
}