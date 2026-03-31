package it.andrea.pokemon.model.number;

import it.andrea.pokemon.battle.Battle;
import it.andrea.pokemon.model.target.ITarget;
import it.andrea.pokemon.utils.PokemonType;
import it.andrea.pokemon.utils.TypeChart;

import java.util.List;

public class TypeEffectiveness implements INumber {

    private final ITarget target;
    private final PokemonType moveType;
    private final int typeIndex;

    public TypeEffectiveness(ITarget target, PokemonType moveType, int typeIndex) {
        this.target = target;
        this.moveType = moveType;
        this.typeIndex = typeIndex;
    }

    @Override
    public double evaluate(Battle battle) {
        List<PokemonType> targetTypes = target.resolve(battle).getTypes();

        if (targetTypes == null || targetTypes.size() <= typeIndex) {
            return 1.0;
        }

        PokemonType targetType = targetTypes.get(typeIndex);

        return TypeChart.getMultiplier(moveType, targetType);
    }
}
