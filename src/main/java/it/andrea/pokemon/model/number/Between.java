package it.andrea.pokemon.model.number;

import it.andrea.pokemon.battle.Battle;

public class Between implements INumber {

    private final double from;
    private final double to;

    public Between(double from, double to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public double evaluate(Battle battle) {
        return from + Math.random() * (to - from);
    }
}
