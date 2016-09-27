package com.plusonetesting.TDDBE;

interface Expression {
    Money reduce(Bank bank, String to);

    Expression plus(Expression addend);
}
