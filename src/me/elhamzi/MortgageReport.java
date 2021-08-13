package me.elhamzi;

import java.text.NumberFormat;
import java.util.Locale;

public class MortgageReport {

    private MortgageCalculator _calculator;

    public MortgageReport(MortgageCalculator calculator) {
        this._calculator = calculator;
    }

    public void printPaymentSchedule() {
        System.out.println("PAYMENT SCHEDULE\n----------------");
        for (short month = 1; month <= _calculator.getYears() * MortgageCalculator.MONTHS_IN_YEAR; month++) {
            double balance = _calculator.calculateLoanBalance(month);
            String loanBalance = NumberFormat.getCurrencyInstance(Locale.US).format(balance);
            System.out.println("Month (" + month + "):" + loanBalance);
        }
    }

    public void printMortgage() {
        double mortgage = _calculator.calculateMortgage();
        String mortgageFormatted = NumberFormat.getCurrencyInstance(Locale.US).format(mortgage);
        System.out.println("\nMORTGAGE\n--------");
        System.out.println("Monthly Payments: " + mortgageFormatted + "\n");
    }
}
