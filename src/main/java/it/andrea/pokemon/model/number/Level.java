package it.andrea.pokemon.model.number;

import it.andrea.pokemon.battle.Battle;
import it.andrea.pokemon.model.target.ITarget;

public class Level implements INumber {

    private final ITarget target;

    public Level(ITarget target) {
        this.target = target;
    }


    @Override
    public double evaluate(Battle battle) {
        return target.resolve(battle).getLevel();
    }
}
