package me.elhamzi;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int principal = (int)readValue("Principal($1k - $1M): ", 1000, 1_000_000);
        float annualInterest = (float)readValue("Annual Interest Rate: ", 0, 30);
        byte years = (byte)readValue("Period(Years): ", 1, 30);

        double mortgage = calculateMortgage(principal,annualInterest, years);

        String mortgageFormatted = NumberFormat.getCurrencyInstance(Locale.US).format(mortgage);
        System.out.print("Mortgage: " + mortgageFormatted);

    }

    public static double readValue(String prompt, double min, double max){
        Scanner scanner = new Scanner (System.in);
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextDouble();
            if (value >= min && value <= max) {
                break;
            }
            System.out.println("Enter a value between " + min + "and " + max + ":");
        }
        return value;
    }

    public static Double calculateMortgage(int principal, float annualInterest, byte years) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        short numberOfPayments = (short)(years * MONTHS_IN_YEAR);

        double mortgage = principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)) / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return mortgage;
    }
}