package it.andrea.pokemon.model.number;

import it.andrea.pokemon.battle.Battle;

public class Exactly implements INumber {

    private final double damage;

    public Exactly(double damage) {
        this.damage = damage;
    }

    @Override
    public double evaluate(Battle battle) {
        return damage;
    }
}
