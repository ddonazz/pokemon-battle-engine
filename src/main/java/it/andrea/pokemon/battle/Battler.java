package it.andrea.pokemon.battle;

import it.andrea.pokemon.utils.PokemonType;

import java.util.Map;
import java.util.Set;

public class Battler {

    private String name;
    private Set<PokemonType> types;
    private PokemonStats stats;
    private int currentHp;
    private Map<StatType, Integer> statStaged;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<PokemonType> getTypes() {
        return types;
    }

    public void setTypes(Set<PokemonType> types) {
        this.types = types;
    }

    public PokemonStats getStats() {
        return stats;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public Map<StatType, Integer> getStatStaged() {
        return statStaged;
    }
}
