package me.elhamzi;

public class MortgageCalculator {
    public static Double calculateMortgage(int principal, float annualInterest, byte years) {
        float monthlyInterest = annualInterest / Main.PERCENT / Main.MONTHS_IN_YEAR;
        short numberOfPayments = (short) (years * Main.MONTHS_IN_YEAR);

        double mortgage = principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)) / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
        // M=P*[(r(1+r)^n)/((1+r)^n-1)].  // https://www.wikihow.com/Calculate-Mortgage-Payments

        return mortgage;
    }

    public static double calculateLoanBalance(int principal, float annualInterest, byte years, short numberOfPaymentsMade) {
        float monthlyInterest = annualInterest / Main.PERCENT / Main.MONTHS_IN_YEAR;
        short numberOfPayments = (short) (years * Main.MONTHS_IN_YEAR);

        double loanBalance = principal * ((Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade)) / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1));
        // B = L[(1 + c)^n - (1 + c)p]/[(1 + c)^n - 1] // https://www.mtgprofessor.com/formulas.htm

        return loanBalance;
    }
}
