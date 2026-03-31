package it.andrea.pokemon.model.effect;

import it.andrea.pokemon.battle.Battle;
import it.andrea.pokemon.battle.Battler;
import it.andrea.pokemon.model.target.ITarget;

public class Faint implements IEffect {

    private final ITarget target;

    public Faint(ITarget target) {
        this.target = target;
    }

    @Override
    public void apply(Battle battle) {
        Battler hitTarget = target.resolve(battle);

        hitTarget.setCurrentHp(0);

        System.out.println(hitTarget.getName() + " is fainted!");
    }
}
