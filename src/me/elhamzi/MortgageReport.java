package me.elhamzi;

import java.text.NumberFormat;
import java.util.Locale;

public class MortgageReport {
    public static void printMortgage(int principal, float annualInterest, byte years) {
        double mortgage = MortgageCalculator.calculateMortgage(principal, annualInterest, years);
        String mortgageFormatted = NumberFormat.getCurrencyInstance(Locale.US).format(mortgage);
        System.out.println("\nMORTGAGE\n--------");
        System.out.println("Monthly Payments: " + mortgageFormatted + "\n");
    }

    public static void printPaymentSchedule(int principal, float annualInterest, byte years) {
        System.out.println("PAYMENT SCHEDULE\n----------------");
        for (short month = 1; month <= years * Main.MONTHS_IN_YEAR; month++) {
            double balance = MortgageCalculator.calculateLoanBalance(principal, annualInterest, years, month);
            String loanBalance = NumberFormat.getCurrencyInstance(Locale.US).format(balance);
            System.out.println("Month (" + month + "):" + loanBalance);
        }
    }
}
