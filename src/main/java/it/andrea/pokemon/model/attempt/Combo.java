package it.andrea.pokemon.model.attempt;

import it.andrea.pokemon.battle.Battle;
import it.andrea.pokemon.model.condition.ICondition;
import it.andrea.pokemon.model.effect.IEffect;
import it.andrea.pokemon.model.number.INumber;

public class Combo implements IAttempt {

    private ICondition<Battle> accuracy;
    private INumber hits;
    private IEffect every;


    @Override
    public void execute(Battle battle) {

    }
}
