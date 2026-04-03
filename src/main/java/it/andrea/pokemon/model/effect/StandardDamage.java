package it.andrea.pokemon.model.effect;

import it.andrea.pokemon.battle.Battle;
import it.andrea.pokemon.model.number.INumber;
import it.andrea.pokemon.model.target.ITarget;
import it.andrea.pokemon.utils.DamageCategory;
import it.andrea.pokemon.utils.PokemonType;

public class StandardDamage implements IEffect {

    private final PokemonType moveType;
    private final DamageCategory category;
    private final INumber basePower;
    private final ITarget target;

    private StandardDamage(PokemonType moveType, DamageCategory category, INumber basePower, ITarget target) {
        this.moveType = moveType;
        this.category = category;
        this.basePower = basePower;
        this.target = target;
    }

    public static StandardDamage of(PokemonType moveType, DamageCategory category, INumber basePower, ITarget target) {
        return new StandardDamage(moveType, category, basePower, target);
    }

    @Override
    public void apply(Battle battle) {
        INumber damageCalculator = battle.getRuleset().createDamageFormula(basePower, moveType, category);

        int finalDamage = (int) damageCalculator.evaluate(battle);

        target.resolve(battle).takeDamage(finalDamage);
    }

}
