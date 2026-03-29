package it.andrea.pokemon.model.effect;

import it.andrea.pokemon.battle.Battle;
import it.andrea.pokemon.model.number.INumber;
import it.andrea.pokemon.model.target.ITarget;

public class RestoreHP implements IEffect {

    private final ITarget target;
    private final INumber hpToRestore;

    public RestoreHP(ITarget target, INumber hpToRestore) {
        this.target = target;
        this.hpToRestore = hpToRestore;
    }

    @Override
    public void apply(Battle battle) {

    }
}
