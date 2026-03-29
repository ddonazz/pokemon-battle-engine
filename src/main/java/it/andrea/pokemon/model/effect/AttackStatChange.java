package it.andrea.pokemon.model.effect;

import it.andrea.pokemon.battle.Battle;
import it.andrea.pokemon.model.number.INumber;
import it.andrea.pokemon.model.target.ITarget;

public class AttackStatChange implements IEffect {

    private final ITarget target;
    private final INumber stages;

    public AttackStatChange(ITarget target, INumber stages) {
        this.target = target;
        this.stages = stages;
    }

    @Override
    public void apply(Battle battle) {

    }
}
