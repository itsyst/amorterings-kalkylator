package me.elhamzi;

import java.text.NumberFormat;
import java.util.Locale;

public class MortgageReport {

    private MortgageCalculator _calculator;
    private final NumberFormat _currency;

    public MortgageReport(MortgageCalculator calculator) {
        this._calculator = calculator;
        this._currency = NumberFormat.getCurrencyInstance(Locale.US);
    }

    public void printPaymentSchedule() {
        System.out.println("PAYMENT SCHEDULE\n----------------");
        for (double balance : _calculator.getRemainingBalances()) {
            String loanBalance = _currency.format(balance);
            System.out.println("Month: " + loanBalance);
        }
    }

    public void printMortgage() {
        double mortgage = _calculator.calculateMortgage();
        String mortgageFormatted = _currency.format(mortgage);
        System.out.println("\nMORTGAGE\n--------");
        System.out.println("Monthly Payments: " + mortgageFormatted + "\n");
    }
}
