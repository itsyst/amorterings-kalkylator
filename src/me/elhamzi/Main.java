package me.elhamzi;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) {

        int principal = (int)readValue("Principal($1k - $1M): ", 1000, 1_000_000);
        float annualInterest = (float)readValue("Annual Interest Rate: ", 0, 30);
        byte years = (byte)readValue("Period(Years): ", 1, 30);

        double mortgage = calculateMortgage(principal,annualInterest, years);
        String mortgageFormatted = NumberFormat.getCurrencyInstance(Locale.US).format(mortgage);
        System.out.println("\nMORTGAGE\n--------");
        System.out.println("Monthly Payments: " + mortgageFormatted +"\n");

        System.out.println("PAYMENT SCHEDULE\n----------------");
        for (short month = 1; month<=years * MONTHS_IN_YEAR; month++){
            double balance = calculateLoanBalance(principal, annualInterest, years, month);
            String loanBalance = NumberFormat.getCurrencyInstance(Locale.US).format(balance);
            System.out.println("Month (" + month + "):" + loanBalance);
        }
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
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        short numberOfPayments = (short)(years * MONTHS_IN_YEAR);

        double mortgage = principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)) / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
        // M=P*[(r(1+r)^n)/((1+r)^n-1)].  // https://www.wikihow.com/Calculate-Mortgage-Payments

        return mortgage;
    }

    public static double calculateLoanBalance(int principal, float annualInterest, byte years, short numberOfPaymentsMade){
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        short numberOfPayments = (short)(years * MONTHS_IN_YEAR);

        double loanBalance = principal*((Math.pow(1 + monthlyInterest,numberOfPayments ) - Math.pow(1 + monthlyInterest,numberOfPaymentsMade))/(Math.pow(1 + monthlyInterest,numberOfPayments )-1));
        // B = L[(1 + c)^n - (1 + c)p]/[(1 + c)^n - 1] // https://www.mtgprofessor.com/formulas.htm

        return loanBalance;
    }
}