package it.andrea.pokemon.model.effect;

import it.andrea.pokemon.battle.Battle;
import it.andrea.pokemon.model.target.ITarget;

public class Paralisys implements IEffect {

    private final ITarget target;

    public Paralisys(ITarget target) {
        this.target = target;
    }

    @Override
    public void apply(Battle battle) {

    }
}
