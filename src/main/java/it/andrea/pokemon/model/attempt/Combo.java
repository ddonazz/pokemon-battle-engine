package it.andrea.pokemon.model.attempt;

import it.andrea.pokemon.battle.Battle;
import it.andrea.pokemon.model.condition.ICondition;
import it.andrea.pokemon.model.effect.IEffect;
import it.andrea.pokemon.model.number.INumber;

/**
 * Represents a multi-strike move execution.
 * This class handles moves that hit the target multiple times in a single turn.
 */
public class Combo implements IAttempt {

    private final ICondition<Battle> accuracy;
    private final INumber hits;
    private final IEffect every;

    public Combo(ICondition<Battle> accuracy, INumber hits, IEffect every) {
        this.accuracy = accuracy;
        this.hits = hits;
        this.every = every;
    }

    @Override
    public void execute(Battle battle) {
        int totalHits = (int) hits.evaluate(battle);

        for (int i = 0; i < totalHits; i++) {
            if (accuracy.check(battle)) {
                every.apply(battle);
            } else {
                break;
            }
        }
    }
}
