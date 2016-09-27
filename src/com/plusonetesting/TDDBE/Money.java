package com.plusonetesting.TDDBE;

class Money implements Expression{

    final int amount;
    private final String currency;

    Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Expression times(int multiplier) {
        return new Money(amount * multiplier, currency);
    }

//    public String toString() {
//        return amount + " " + currency;
//    }

    public boolean equals(Object object) {
        if (getClass() != object.getClass())
                return false;
        Money money = (Money) object;
        return amount == money.amount
                && currency().equals(money.currency());
    }

    static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    String currency() {
        return currency;
    }

    public Money reduce(Bank bank, String to){
        int rate = bank.rate(currency, to);
        return new Money(amount/rate, to);
    }

    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }
}
