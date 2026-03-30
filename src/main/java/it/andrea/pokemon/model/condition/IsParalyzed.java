package it.andrea.pokemon.model.condition;

import it.andrea.pokemon.battle.Battler;
import it.andrea.pokemon.battle.StatusCondition;

public class IsParalyzed implements ICondition<Battler> {

    @Override
    public boolean check(Battler battler) {
        return battler.getStatusCondition().equals(StatusCondition.PARALYSIS);
    }

}
