package it.andrea.pokemon.battle;

import it.andrea.pokemon.model.rules.IGenerationRuleset;

/**
 * Represents a battle between two battlers in the Pokémon game.
 */
public class Battle {

    private Battler attacker;
    private Battler defender;
    private int turnCounter;
    private IGenerationRuleset ruleset;

    public Battler getAttacker() {
        return attacker;
    }

    public void setAttacker(Battler attacker) {
        this.attacker = attacker;
    }

    public Battler getDefender() {
        return defender;
    }

    public void setDefender(Battler defender) {
        this.defender = defender;
    }

    public int getTurnCounter() {
        return turnCounter;
    }

    public void setTurnCounter(int turnCounter) {
        this.turnCounter = turnCounter;
    }

    public IGenerationRuleset getRuleset() {
        return ruleset;
    }
}
