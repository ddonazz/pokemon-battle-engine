package it.andrea.pokemon.model.condition;

import it.andrea.pokemon.battle.Battle;
import it.andrea.pokemon.battle.Battler;
import it.andrea.pokemon.model.target.ITarget;

public class For implements ICondition<Battle> {

    private final ITarget target;
    private final ICondition<Battler> condition;

    public For(ITarget target, ICondition<Battler> condition) {
        this.target = target;
        this.condition = condition;
    }

    @Override
    public boolean check(Battle battle) {
        Battler resolvedTarget = target.resolve(battle);
        return condition.check(resolvedTarget);
    }
}
