package it.andrea.pokemon.model.number;

import it.andrea.pokemon.battle.Battle;
import it.andrea.pokemon.model.target.ITarget;

public class MaxHP implements INumber {

    private final ITarget target;

    public MaxHP(ITarget target) {
        this.target = target;
    }

    @Override
    public double evaluate(Battle battle) {
        return 0;
    }
}
