package it.andrea.pokemon.model.rules;

import it.andrea.pokemon.utils.PokemonType;

public interface ITypeChart {

    double getMultiplier(PokemonType attacker, PokemonType defender);

}
