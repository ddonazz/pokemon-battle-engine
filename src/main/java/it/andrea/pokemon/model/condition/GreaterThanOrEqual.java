package it.andrea.pokemon.model.condition;

import it.andrea.pokemon.battle.Battle;
import it.andrea.pokemon.model.number.INumber;

public class GreaterThanOrEqual implements ICondition<Battle> {

    private final INumber left;
    private final INumber right;

    public GreaterThanOrEqual(INumber left, INumber right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean check(Battle battle) {
        return left.evaluate(battle) >= right.evaluate(battle);
    }
}
