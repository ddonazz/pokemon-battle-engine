package it.andrea.pokemon.model.number;

import it.andrea.pokemon.battle.Battle;
import it.andrea.pokemon.model.target.ITarget;
import it.andrea.pokemon.utils.PokemonType;

public class SameTypeAttackBonus implements INumber {

    private final PokemonType moveType;
    private final ITarget target;

    public SameTypeAttackBonus(ITarget target, PokemonType moveType) {
        this.target = target;
        this.moveType = moveType;
    }
    
    @Override
    public double evaluate(Battle battle) {
        return target.resolve(battle).getTypes().contains(moveType) ? 1.5 : 1.0;
    }
}
