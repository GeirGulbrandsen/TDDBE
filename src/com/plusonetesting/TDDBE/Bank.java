package com.plusonetesting.TDDBE;

import java.util.Hashtable;

class Bank {
    int rate(String from, String to) {
        if (from.equals(to)) return 1;
        return (int) rates.get(new Pair(from, to));

    }

    Money reduce(Expression source, String to) {
        return source.reduce(this, to);
    }

    private Hashtable rates = new Hashtable();

    public void addRate(String from, String to, int rate) {
        rates.put(new Pair(from, to), rate);
    }
}
