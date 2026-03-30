package it.andrea.pokemon.model.effect;

import it.andrea.pokemon.battle.Battle;
import it.andrea.pokemon.model.target.ITarget;

public class Faint implements IEffect {

    private final ITarget target;

    public Faint(ITarget target) {
        this.target = target;
    }

    @Override
    public void apply(Battle battle) {
        //TODO
    }
}
