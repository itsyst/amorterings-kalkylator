package me.elhamzi;

public class MortgageCalculator {
    protected final static byte MONTHS_IN_YEAR = 12;
    private final static byte PERCENT = 100;

    private int _principal;
    private float _annualInterest;
    private byte _years;

    public MortgageCalculator(int principal, float annualInterest, byte years) {
        this._principal = principal;
        this._annualInterest = annualInterest;
        this._years = years;
    }

    public double calculateMortgage() {
        float monthlyInterest = getMonthlyInterest();
        short numberOfPayments = getNumberOfPayments();

        double mortgage = _principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)) / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
        // M=P*[(r(1+r)^n)/((1+r)^n-1)].  // https://www.wikihow.com/Calculate-Mortgage-Payments

        return mortgage;
    }

    public double calculateLoanBalance(short numberOfPaymentsMade) {
        float monthlyInterest = getMonthlyInterest();
        short numberOfPayments = getNumberOfPayments();

        double loanBalance = _principal * ((Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade)) / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1));
        // B = L[(1 + c)^n - (1 + c)p]/[(1 + c)^n - 1] // https://www.mtgprofessor.com/formulas.htm

        return loanBalance;
    }

    public double[] getRemainingBalances() {
        var balances = new double[getNumberOfPayments()];
        for (short month = 1; month <= balances.length; month++)
            balances[month - 1] = calculateLoanBalance(month);

        return balances;
    }

    private float getMonthlyInterest() {
        return _annualInterest / PERCENT / MONTHS_IN_YEAR;
    }

    private short getNumberOfPayments() {
        return (short) (_years * MONTHS_IN_YEAR);
    }
}
