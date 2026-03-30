package it.andrea.pokemon.model.attempt;

import it.andrea.pokemon.battle.Battle;
import it.andrea.pokemon.model.condition.ICondition;
import it.andrea.pokemon.model.effect.IEffect;

public class Attempt implements IAttempt {

    private final ICondition<Battle> accuracy;
    private final IEffect onHit;
    private final IEffect onMiss;
    private final IEffect after;

    public Attempt(ICondition<Battle> accuracy, IEffect onHit) {
        this.accuracy = accuracy;
        this.onHit = onHit;
        onMiss = null;
        after = null;
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
