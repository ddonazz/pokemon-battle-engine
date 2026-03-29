package it.andrea.pokemon.model.effect;

import it.andrea.pokemon.battle.Battle;
import it.andrea.pokemon.model.number.INumber;
import it.andrea.pokemon.model.target.ITarget;

public class DirectDamage implements IEffect {

    private final ITarget target;
    private final INumber damage;

    public DirectDamage(ITarget target, INumber damage) {
        this.target = target;
        this.damage = damage;
    }

    @Override
    public void apply(Battle battle) {
        //TODO
    }
}
