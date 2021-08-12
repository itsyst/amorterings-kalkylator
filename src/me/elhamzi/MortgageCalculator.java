package me.elhamzi;

public class MortgageCalculator {
    private int _principal;
    private float _annualInterest;
    private byte _years;

    public MortgageCalculator(int principal, float annualInterest, byte years) {
        this._principal = principal;
        this._annualInterest = annualInterest;
        this._years = years;
    }

    public double calculateMortgage() {
        float monthlyInterest = _annualInterest / Main.PERCENT / Main.MONTHS_IN_YEAR;
        short numberOfPayments = (short) (_years * Main.MONTHS_IN_YEAR);

        double mortgage = _principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)) / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
        // M=P*[(r(1+r)^n)/((1+r)^n-1)].  // https://www.wikihow.com/Calculate-Mortgage-Payments

        return mortgage;
    }

    public double calculateLoanBalance(short numberOfPaymentsMade) {
        float monthlyInterest = _annualInterest / Main.PERCENT / Main.MONTHS_IN_YEAR;
        short numberOfPayments = (short) (_years * Main.MONTHS_IN_YEAR);

        double loanBalance = _principal * ((Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade)) / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1));
        // B = L[(1 + c)^n - (1 + c)p]/[(1 + c)^n - 1] // https://www.mtgprofessor.com/formulas.htm

        return loanBalance;
    }
}
