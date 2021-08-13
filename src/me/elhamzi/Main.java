package me.elhamzi;

public class Main {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) {
        int principal = (int) Console.readValue("Principal($1k - $1M): ", 1000, 1_000_000);
        float annualInterest = (float) Console.readValue("Annual Interest Rate: ", 0, 30);
        byte years = (byte) Console.readValue("Period(Years): ", 1, 30);

        var calculator = new MortgageCalculator(principal, annualInterest,years);
        var report = new MortgageReport(calculator);
        report.printMortgage();
        report.printPaymentSchedule();
    }

}