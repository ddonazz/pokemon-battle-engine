package it.andrea.pokemon.utils;

import it.andrea.pokemon.model.rules.IGenerationRuleset;
import it.andrea.pokemon.model.rules.gen1.Gen1Ruleset;

public final class PokemonRules {

    public static final IGenerationRuleset GEN_1 = Gen1Ruleset.getInstance();

    private PokemonRules() {
    }
    
}
