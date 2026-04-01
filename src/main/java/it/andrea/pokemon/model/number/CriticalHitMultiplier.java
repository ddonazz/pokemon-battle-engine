package it.andrea.pokemon.model.number;

import it.andrea.pokemon.battle.Battle;
import it.andrea.pokemon.model.condition.ICondition;

public class CriticalHitMultiplier implements INumber {

    private final ICondition<Battle> condition;
    private final INumber multiplier;

    public CriticalHitMultiplier(ICondition<Battle> condition, INumber multiplier) {
        this.condition = condition;
        this.multiplier = multiplier;
    }
    
    @Override
    public double evaluate(Battle battle) {
        if (condition.check(battle)) {
            System.out.println("Critical hit!");
            return multiplier.evaluate(battle);
        }

        return 1.0;
    }
}
