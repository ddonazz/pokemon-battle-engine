package it.andrea.pokemon.utils;

import java.util.EnumMap;
import java.util.Map;

public final class TypeChart {

    private static final Map<PokemonType, Map<PokemonType, Double>> CHART = new EnumMap<>(PokemonType.class);

    static {
        for (PokemonType type : PokemonType.values()) {
            CHART.put(type, new EnumMap<>(PokemonType.class));
        }

        // --- NORMAL ---
        set(PokemonType.NORMAL, PokemonType.ROCK, 0.5);
        set(PokemonType.NORMAL, PokemonType.STEEL, 0.5);
        set(PokemonType.NORMAL, PokemonType.GHOST, 0.0);

        // --- FIRE ---
        set(PokemonType.FIRE, PokemonType.FIRE, 0.5);
        set(PokemonType.FIRE, PokemonType.WATER, 0.5);
        set(PokemonType.FIRE, PokemonType.GRASS, 2.0);
        set(PokemonType.FIRE, PokemonType.ICE, 2.0);
        set(PokemonType.FIRE, PokemonType.BUG, 2.0);
        set(PokemonType.FIRE, PokemonType.ROCK, 0.5);
        set(PokemonType.FIRE, PokemonType.DRAGON, 0.5);
        set(PokemonType.FIRE, PokemonType.STEEL, 2.0);

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
        set(PokemonType.GRASS, PokemonType.STEEL, 0.5);

        // --- ICE ---
        set(PokemonType.ICE, PokemonType.FIRE, 0.5);
        set(PokemonType.ICE, PokemonType.WATER, 0.5);
        set(PokemonType.ICE, PokemonType.GRASS, 2.0);
        set(PokemonType.ICE, PokemonType.ICE, 0.5);
        set(PokemonType.ICE, PokemonType.GROUND, 2.0);
        set(PokemonType.ICE, PokemonType.FLYING, 2.0);
        set(PokemonType.ICE, PokemonType.DRAGON, 2.0);
        set(PokemonType.ICE, PokemonType.STEEL, 0.5);

        // --- FIGHTING ---
        set(PokemonType.FIGHTING, PokemonType.NORMAL, 2.0);
        set(PokemonType.FIGHTING, PokemonType.ICE, 2.0);
        set(PokemonType.FIGHTING, PokemonType.POISON, 0.5);
        set(PokemonType.FIGHTING, PokemonType.FLYING, 0.5);
        set(PokemonType.FIGHTING, PokemonType.PSYCHIC, 0.5);
        set(PokemonType.FIGHTING, PokemonType.BUG, 0.5);
        set(PokemonType.FIGHTING, PokemonType.ROCK, 2.0);
        set(PokemonType.FIGHTING, PokemonType.GHOST, 0.0);
        set(PokemonType.FIGHTING, PokemonType.DARK, 2.0);
        set(PokemonType.FIGHTING, PokemonType.STEEL, 2.0);
        set(PokemonType.FIGHTING, PokemonType.FAIRY, 0.5);

        // --- POISON ---
        set(PokemonType.POISON, PokemonType.GRASS, 2.0);
        set(PokemonType.POISON, PokemonType.POISON, 0.5);
        set(PokemonType.POISON, PokemonType.GROUND, 0.5);
        set(PokemonType.POISON, PokemonType.ROCK, 0.5);
        set(PokemonType.POISON, PokemonType.GHOST, 0.5);
        set(PokemonType.POISON, PokemonType.STEEL, 0.0);
        set(PokemonType.POISON, PokemonType.FAIRY, 2.0);

        // --- GROUND ---
        set(PokemonType.GROUND, PokemonType.FIRE, 2.0);
        set(PokemonType.GROUND, PokemonType.ELECTRIC, 2.0);
        set(PokemonType.GROUND, PokemonType.GRASS, 0.5);
        set(PokemonType.GROUND, PokemonType.POISON, 2.0);
        set(PokemonType.GROUND, PokemonType.FLYING, 0.0);
        set(PokemonType.GROUND, PokemonType.BUG, 0.5);
        set(PokemonType.GROUND, PokemonType.ROCK, 2.0);
        set(PokemonType.GROUND, PokemonType.STEEL, 2.0);

        // --- FLYING ---
        set(PokemonType.FLYING, PokemonType.ELECTRIC, 0.5);
        set(PokemonType.FLYING, PokemonType.GRASS, 2.0);
        set(PokemonType.FLYING, PokemonType.FIGHTING, 2.0);
        set(PokemonType.FLYING, PokemonType.BUG, 2.0);
        set(PokemonType.FLYING, PokemonType.ROCK, 0.5);
        set(PokemonType.FLYING, PokemonType.STEEL, 0.5);

        // --- PSYCHIC ---
        set(PokemonType.PSYCHIC, PokemonType.FIGHTING, 2.0);
        set(PokemonType.PSYCHIC, PokemonType.POISON, 2.0);
        set(PokemonType.PSYCHIC, PokemonType.PSYCHIC, 0.5);
        set(PokemonType.PSYCHIC, PokemonType.DARK, 0.0);
        set(PokemonType.PSYCHIC, PokemonType.STEEL, 0.5);

        // --- BUG ---
        set(PokemonType.BUG, PokemonType.FIRE, 0.5);
        set(PokemonType.BUG, PokemonType.GRASS, 2.0);
        set(PokemonType.BUG, PokemonType.FIGHTING, 0.5);
        set(PokemonType.BUG, PokemonType.POISON, 0.5);
        set(PokemonType.BUG, PokemonType.FLYING, 0.5);
        set(PokemonType.BUG, PokemonType.PSYCHIC, 2.0);
        set(PokemonType.BUG, PokemonType.GHOST, 0.5);
        set(PokemonType.BUG, PokemonType.DARK, 2.0);
        set(PokemonType.BUG, PokemonType.STEEL, 0.5);
        set(PokemonType.BUG, PokemonType.FAIRY, 0.5);

        // --- ROCK ---
        set(PokemonType.ROCK, PokemonType.FIRE, 2.0);
        set(PokemonType.ROCK, PokemonType.ICE, 2.0);
        set(PokemonType.ROCK, PokemonType.FIGHTING, 0.5);
        set(PokemonType.ROCK, PokemonType.GROUND, 0.5);
        set(PokemonType.ROCK, PokemonType.FLYING, 2.0);
        set(PokemonType.ROCK, PokemonType.BUG, 2.0);
        set(PokemonType.ROCK, PokemonType.STEEL, 0.5);

        // --- GHOST ---
        set(PokemonType.GHOST, PokemonType.NORMAL, 0.0);
        set(PokemonType.GHOST, PokemonType.PSYCHIC, 2.0);
        set(PokemonType.GHOST, PokemonType.GHOST, 2.0);
        set(PokemonType.GHOST, PokemonType.DARK, 0.5);

        // --- DRAGON ---
        set(PokemonType.DRAGON, PokemonType.DRAGON, 2.0);
        set(PokemonType.DRAGON, PokemonType.STEEL, 0.5);
        set(PokemonType.DRAGON, PokemonType.FAIRY, 0.0);

        // --- DARK ---
        set(PokemonType.DARK, PokemonType.FIGHTING, 0.5);
        set(PokemonType.DARK, PokemonType.PSYCHIC, 2.0);
        set(PokemonType.DARK, PokemonType.GHOST, 2.0);
        set(PokemonType.DARK, PokemonType.DARK, 0.5);
        set(PokemonType.DARK, PokemonType.FAIRY, 0.5);

        // --- STEEL ---
        set(PokemonType.STEEL, PokemonType.FIRE, 0.5);
        set(PokemonType.STEEL, PokemonType.WATER, 0.5);
        set(PokemonType.STEEL, PokemonType.ELECTRIC, 0.5);
        set(PokemonType.STEEL, PokemonType.ICE, 2.0);
        set(PokemonType.STEEL, PokemonType.ROCK, 2.0);
        set(PokemonType.STEEL, PokemonType.STEEL, 0.5);
        set(PokemonType.STEEL, PokemonType.FAIRY, 2.0);

        // --- FAIRY ---
        set(PokemonType.FAIRY, PokemonType.FIRE, 0.5);
        set(PokemonType.FAIRY, PokemonType.FIGHTING, 2.0);
        set(PokemonType.FAIRY, PokemonType.POISON, 0.5);
        set(PokemonType.FAIRY, PokemonType.DRAGON, 2.0);
        set(PokemonType.FAIRY, PokemonType.DARK, 2.0);
        set(PokemonType.FAIRY, PokemonType.STEEL, 0.5);
    }

    private TypeChart() {
    }

    private static void set(PokemonType attacker, PokemonType defender, double multiplier) {
        CHART.get(attacker).put(defender, multiplier);
    }

    public static double getMultiplier(PokemonType attacker, PokemonType defender) {
        if (attacker == null || defender == null) {
            return 1.0;
        }

        return CHART.get(attacker).getOrDefault(defender, 1.0);
    }
}