package it.andrea.pokemon.battle;

public enum StatusCondition {
    NONE,
    BURN,         // Burn: Halves Attack, inflicts damage at the end of each turn
    PARALYSIS,    // Paralysis: Halves Speed, 25% chance of being unable to move
    POISON,       // Poison: Inflicts damage at the end of each turn
    BAD_POISON,   // Bad Poison (Toxic): Inflicts increasing damage at the end of each turn
    SLEEP,        // Sleep: Unable to attack for a certain number of turns
    FREEZE        // Freeze: Unable to attack until thawed
}