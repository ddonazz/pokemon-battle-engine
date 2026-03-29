package it.andrea.pokemon.model.condition;

import it.andrea.pokemon.battle.Battle;
import it.andrea.pokemon.battle.Battler;
import it.andrea.pokemon.model.target.ITarget;

public class For implements ICondition<Battle> {

    private ITarget target;
    private ICondition<Battler> condition;

    @Override
    public boolean check(Battle battle) {
        return false;
    }
}
