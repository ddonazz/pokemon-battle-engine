package it.andrea.pokemon.model.rules.gen1;

import it.andrea.pokemon.model.rules.ITypeChart;
import it.andrea.pokemon.utils.PokemonType;

import java.util.EnumMap;
import java.util.Map;

public final class Gen1TypeChart implements ITypeChart {

    private static final ITypeChart INSTANCE = new Gen1TypeChart();
    private final Map<PokemonType, Map<PokemonType, Double>> CHART = new EnumMap<>(PokemonType.class);

    private Gen1TypeChart() {
        for (PokemonType type : PokemonType.values()) {
            CHART.put(type, new EnumMap<>(PokemonType.class));
        }

        // --- NORMAL ---
        set(PokemonType.NORMAL, PokemonType.ROCK, 0.5);
        set(PokemonType.NORMAL, PokemonType.GHOST, 0.0);

        // --- FIRE ---
        set(PokemonType.FIRE, PokemonType.FIRE, 0.5);
        set(PokemonType.FIRE, PokemonType.WATER, 0.5);
        set(PokemonType.FIRE, PokemonType.GRASS, 2.0);
        set(PokemonType.FIRE, PokemonType.ICE, 2.0);
        set(PokemonType.FIRE, PokemonType.BUG, 2.0);
        set(PokemonType.FIRE, PokemonType.ROCK, 0.5);
        set(PokemonType.FIRE, PokemonType.DRAGON, 0.5);

        // --- WATER ---
        set(PokemonType.WATER, PokemonType.FIRE, 2.0);
        set(PokemonType.WATER, PokemonType.WATER, 0.5);
        set(PokemonType.WATER, PokemonType.GRASS, 0.5);
        set(PokemonType.WATER, PokemonType.GROUND, 2.0);
        set(PokemonType.WATER, PokemonType.ROCK, 2.0);
        set(PokemonType.WATER, PokemonType.DRAGON, 0.5);

        // --- ELECTRIC ---
        set(PokemonType.ELECTRIC, PokemonType.WATER, 2.0);
        set(PokemonType.ELECTRIC, PokemonType.ELECTRIC, 0.5);
        set(PokemonType.ELECTRIC, PokemonType.GRASS, 0.5);
        set(PokemonType.ELECTRIC, PokemonType.GROUND, 0.0);
        set(PokemonType.ELECTRIC, PokemonType.FLYING, 2.0);
        set(PokemonType.ELECTRIC, PokemonType.DRAGON, 0.5);

        // --- GRASS ---
        set(PokemonType.GRASS, PokemonType.FIRE, 0.5);
        set(PokemonType.GRASS, PokemonType.WATER, 2.0);
        set(PokemonType.GRASS, PokemonType.GRASS, 0.5);
        set(PokemonType.GRASS, PokemonType.POISON, 0.5);
        set(PokemonType.GRASS, PokemonType.GROUND, 2.0);
        set(PokemonType.GRASS, PokemonType.FLYING, 0.5);
        set(PokemonType.GRASS, PokemonType.BUG, 0.5);
        set(PokemonType.GRASS, PokemonType.ROCK, 2.0);
        set(PokemonType.GRASS, PokemonType.DRAGON, 0.5);

        // --- ICE ---
        set(PokemonType.ICE, PokemonType.WATER, 0.5);
        set(PokemonType.ICE, PokemonType.GRASS, 2.0);
        set(PokemonType.ICE, PokemonType.ICE, 0.5);
        set(PokemonType.ICE, PokemonType.GROUND, 2.0);
        set(PokemonType.ICE, PokemonType.FLYING, 2.0);
        set(PokemonType.ICE, PokemonType.DRAGON, 2.0);
        // Nota: ICE vs FIRE era 1.0 in Gen 1

        // --- FIGHTING ---
        set(PokemonType.FIGHTING, PokemonType.NORMAL, 2.0);
        set(PokemonType.FIGHTING, PokemonType.ICE, 2.0);
        set(PokemonType.FIGHTING, PokemonType.POISON, 0.5);
        set(PokemonType.FIGHTING, PokemonType.FLYING, 0.5);
        set(PokemonType.FIGHTING, PokemonType.PSYCHIC, 0.5);
        set(PokemonType.FIGHTING, PokemonType.BUG, 0.5);
        set(PokemonType.FIGHTING, PokemonType.ROCK, 2.0);
        set(PokemonType.FIGHTING, PokemonType.GHOST, 0.0);

        // --- POISON ---
        set(PokemonType.POISON, PokemonType.GRASS, 2.0);
        set(PokemonType.POISON, PokemonType.POISON, 0.5);
        set(PokemonType.POISON, PokemonType.GROUND, 0.5);
        set(PokemonType.POISON, PokemonType.BUG, 2.0);
        set(PokemonType.POISON, PokemonType.ROCK, 0.5);
        set(PokemonType.POISON, PokemonType.GHOST, 0.5);

        // --- GROUND ---
        set(PokemonType.GROUND, PokemonType.FIRE, 2.0);
        set(PokemonType.GROUND, PokemonType.ELECTRIC, 2.0);
        set(PokemonType.GROUND, PokemonType.GRASS, 0.5);
        set(PokemonType.GROUND, PokemonType.POISON, 2.0);
        set(PokemonType.GROUND, PokemonType.FLYING, 0.0);
        set(PokemonType.GROUND, PokemonType.BUG, 0.5);
        set(PokemonType.GROUND, PokemonType.ROCK, 2.0);

        // --- FLYING ---
        set(PokemonType.FLYING, PokemonType.ELECTRIC, 0.5);
        set(PokemonType.FLYING, PokemonType.GRASS, 2.0);
        set(PokemonType.FLYING, PokemonType.FIGHTING, 2.0);
        set(PokemonType.FLYING, PokemonType.BUG, 2.0);
        set(PokemonType.FLYING, PokemonType.ROCK, 0.5);

        // --- PSYCHIC ---
        set(PokemonType.PSYCHIC, PokemonType.FIGHTING, 2.0);
        set(PokemonType.PSYCHIC, PokemonType.POISON, 2.0);
        set(PokemonType.PSYCHIC, PokemonType.PSYCHIC, 0.5);

        // --- BUG ---
        set(PokemonType.BUG, PokemonType.FIRE, 0.5);
        set(PokemonType.BUG, PokemonType.GRASS, 2.0);
        set(PokemonType.BUG, PokemonType.FIGHTING, 0.5);
        set(PokemonType.BUG, PokemonType.POISON, 2.0);
        set(PokemonType.BUG, PokemonType.FLYING, 0.5);
        set(PokemonType.BUG, PokemonType.PSYCHIC, 2.0);

        // --- ROCK ---
        set(PokemonType.ROCK, PokemonType.FIRE, 2.0);
        set(PokemonType.ROCK, PokemonType.ICE, 2.0);
        set(PokemonType.ROCK, PokemonType.FIGHTING, 0.5);
        set(PokemonType.ROCK, PokemonType.GROUND, 0.5);
        set(PokemonType.ROCK, PokemonType.FLYING, 2.0);
        set(PokemonType.ROCK, PokemonType.BUG, 2.0);

        // --- GHOST ---
        set(PokemonType.GHOST, PokemonType.NORMAL, 0.0);
        set(PokemonType.GHOST, PokemonType.PSYCHIC, 0.0);
        set(PokemonType.GHOST, PokemonType.GHOST, 2.0);

        // --- DRAGON ---
        set(PokemonType.DRAGON, PokemonType.DRAGON, 2.0);
    }

    public static ITypeChart getInstance() {
        return INSTANCE;
    }

    private void set(PokemonType attacker, PokemonType defender, double multiplier) {
        CHART.get(attacker).put(defender, multiplier);
    }

    public double getMultiplier(PokemonType attacker, PokemonType defender) {
        if (attacker == null || defender == null) {
            return 1.0;
        }
        return CHART.get(attacker).getOrDefault(defender, 1.0);
    }
}