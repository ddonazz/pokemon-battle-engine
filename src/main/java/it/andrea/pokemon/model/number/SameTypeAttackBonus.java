package it.andrea.pokemon.model.number;

import it.andrea.pokemon.battle.Battle;
import it.andrea.pokemon.utils.PokemonType;

public class SameTypeAttackBonus implements INumber {

    private final PokemonType moveType;

    public SameTypeAttackBonus(PokemonType moveType) {
        this.moveType = moveType;
    }
    
    @Override
    public double evaluate(Battle battle) {
        return battle.getAttacker().getTypes().contains(moveType) ? 1.5 : 1.0;
    }
}
