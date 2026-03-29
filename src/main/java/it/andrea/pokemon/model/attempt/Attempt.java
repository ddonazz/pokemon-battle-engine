package it.andrea.pokemon.model.attempt;

import it.andrea.pokemon.battle.Battle;
import it.andrea.pokemon.model.condition.ICondition;
import it.andrea.pokemon.model.effect.IEffect;

public class Attempt implements IAttempt {

    private ICondition<Battle> accuracy;
    private IEffect onHit;
    private IEffect onMiss;
    private IEffect after;

    public Attempt(ICondition<Battle> accuracy, IEffect onHit) {
        this.accuracy = accuracy;
        this.onHit = onHit;
    }

    @Override
    public void execute(Battle battle) {
        if (accuracy.check(battle)) {
            onHit.apply(battle);
        } else if (onMiss != null) {
            onMiss.apply(battle);
        }
        if (after != null) {
            after.apply(battle);
        }
    }
}
