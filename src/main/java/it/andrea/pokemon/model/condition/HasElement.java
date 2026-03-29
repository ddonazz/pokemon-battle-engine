package it.andrea.pokemon.model.condition;

import it.andrea.pokemon.battle.Battler;
import it.andrea.pokemon.utils.PokemonType;

public class HasElement implements ICondition<Battler> {

    private final PokemonType element;

    public HasElement(PokemonType element) {
        this.element = element;
    }

    @Override
    public boolean check(Battler battler) {
        return battler.getTypes().contains(element);
    }
}
