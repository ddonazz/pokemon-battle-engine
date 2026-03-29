package it.andrea.pokemon.model.effect;

import it.andrea.pokemon.battle.Battle;

import java.util.List;

/**
 * A sequence of effects that are applied in order.
 */
public class Sequence implements IEffect {

    private final List<IEffect> effects;

    public Sequence(List<IEffect> effects) {
        this.effects = effects;
    }

    @Override
    public void apply(Battle battle) {
        for (IEffect effect : effects) {
            effect.apply(battle);
        }
    }
}
