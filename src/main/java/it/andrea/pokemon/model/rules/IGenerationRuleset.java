package it.andrea.pokemon.model.rules;

import it.andrea.pokemon.model.number.INumber;
import it.andrea.pokemon.utils.DamageCategory;
import it.andrea.pokemon.utils.PokemonType;

public interface IGenerationRuleset {

    INumber createDamageFormula(INumber basePower, PokemonType moveType, DamageCategory category);

    ITypeChart getTypeChart();

}
