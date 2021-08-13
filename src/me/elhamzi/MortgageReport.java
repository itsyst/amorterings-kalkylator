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
        for (double balance : _calculator.getRemainingBalances()) {
            String loanBalance = NumberFormat.getCurrencyInstance(Locale.US).format(balance);
            System.out.println("Month: " + loanBalance);
        }
    }

    public void printMortgage() {
        double mortgage = _calculator.calculateMortgage();
        String mortgageFormatted = NumberFormat.getCurrencyInstance(Locale.US).format(mortgage);
        System.out.println("\nMORTGAGE\n--------");
        System.out.println("Monthly Payments: " + mortgageFormatted + "\n");
    }
}
