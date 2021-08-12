package me.elhamzi;

import java.util.Scanner;

public class Console {
    private static Scanner _scanner = new Scanner(System.in);

    public static double readValue(String prompt) {
        System.out.print(prompt);
        return _scanner.nextDouble();
    }

    public static double readValue(String prompt, double min, double max) {
        double value;
        while (true) {
            System.out.print(prompt);
            value = _scanner.nextDouble();
            if (value >= min && value <= max) {
                break;
            }
            System.out.println("Enter a value between " + min + " and " + max + ":");
        }
        return value;
    }
}
