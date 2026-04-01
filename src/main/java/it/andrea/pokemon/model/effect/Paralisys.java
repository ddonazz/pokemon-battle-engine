package it.andrea.pokemon.model.effect;

import it.andrea.pokemon.battle.Battle;
import it.andrea.pokemon.model.target.ITarget;
import it.andrea.pokemon.utils.StatusCondition;

public class Paralisys implements IEffect {

    private final ITarget target;

    public Paralisys(ITarget target) {
        this.target = target;
    }

    @Override
    public void apply(Battle battle) {
        target.resolve(battle).setStatusCondition(StatusCondition.PARALYSIS);
    }
}
