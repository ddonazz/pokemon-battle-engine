package it.andrea.pokemon.model.effect;

import it.andrea.pokemon.battle.Battle;
import it.andrea.pokemon.model.number.INumber;
import it.andrea.pokemon.model.target.ITarget;

public class StandardDamage implements IEffect {

    private final INumber basePower;
    private final ITarget target;

    public StandardDamage(INumber basePower, ITarget target) {
        this.basePower = basePower;
        this.target = target;
    }

    @Override
    public void apply(Battle battle) {
        double power = basePower.evaluate(battle);
        int finalDamage = battle.getDamageFormula().calculate(battle, power);
        target.resolve(battle).takeDamage(finalDamage);
    }
}
