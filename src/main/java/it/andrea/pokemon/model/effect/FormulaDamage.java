package it.andrea.pokemon.model.effect;

import it.andrea.pokemon.battle.Battle;
import it.andrea.pokemon.model.number.INumber;
import it.andrea.pokemon.model.target.ITarget;

public class FormulaDamage implements IEffect {

    private final INumber number;
    private final ITarget target;

    public FormulaDamage(INumber number, ITarget target) {
        this.number = number;
        this.target = target;
    }

    @Override
    public void apply(Battle battle) {
        target.resolve(battle).setCurrentHp(
                target.resolve(battle).getCurrentHp() - (int) number.evaluate(battle)
        );
    }
}
