package ru.university.lab2.strings;

public class Task04TextProcessing {
    public void run() {
        palindromeDemo();
        reverseWordsDemo();
        countCharsDemo();
        caesarDemo();
        longestWordDemo();
    }

    private void palindromeDemo() {
        System.out.println(" 1. Палиндром ");
        System.out.println(isPalindrome("А роза упала на лапу Азора"));
        System.out.println(isPalindrome("Привет"));
    }

    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;
            left++; right--;
        }
        return true;
    }

    private void reverseWordsDemo() {
        System.out.println("\n2. Разворот слов ");
        System.out.println(reverseWords("кот съел мышь"));
    }

    public String reverseWords(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i > 0) sb.append(" ");
        }
        return sb.toString();
    }

    private void countCharsDemo() {
        System.out.println("\n 3. Подсчёт символов ");
        String text = "Привет, Мир! 123";
        int vowels = 0, consonants = 0, digits = 0, spaces = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = Character.toLowerCase(text.charAt(i));
            if (Character.isDigit(c)) digits++;
            else if (c == ' ') spaces++;
            else if (isVowel(c)) vowels++;
            else if (Character.isLetter(c)) consonants++;
        }
        System.out.println("Гласных: " + vowels + ", Согласных: " + consonants + ", Цифр: " + digits + ", Пробелов: " + spaces);
    }

    private boolean isVowel(char c) { return "аеёиоуыэюяaeiouy".indexOf(c) >= 0; }

    private void caesarDemo() {
        System.out.println("\n 4. Цезарь ");
        String enc = caesarEncrypt("Hello, World!", 3);
        System.out.println("Зашифровано: " + enc + " | Расшифровано: " + caesarDecrypt(enc, 3));
    }

    public String caesarEncrypt(String text, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) sb.append(shift(text.charAt(i), k));
        return sb.toString();
    }

    public String caesarDecrypt(String text, int k) { return caesarEncrypt(text, -k); }

    private char shift(char c, int k) {
        if (c >= 'a' && c <= 'z') return (char) ('a' + ((c - 'a' + k) % 26 + 26) % 26);
        if (c >= 'A' && c <= 'Z') return (char) ('A' + ((c - 'A' + k) % 26 + 26) % 26);
        return c;
    }

    private void longestWordDemo() {
        System.out.println("\n 5. Самое длинное слово ");
        System.out.println(findLongestWord("f ff fff fffff fffffffffffffffffffffffff ff f"));
    }

    public String findLongestWord(String text) {
        String[] words = text.split(" ");
        String longest = "";
        for (String w : words) if (w.length() > longest.length()) longest = w;
        return longest;
    }
}