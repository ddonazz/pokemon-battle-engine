package it.andrea.pokemon.battle;

import it.andrea.pokemon.model.rules.IGenerationRuleset;

/**
 * Represents a battle between two battlers in the Pokémon game.
 */
public class Battle {

    private final Battler player1;
    private final Battler player2;
    private final IGenerationRuleset ruleset;

    private Battler attacker;
    private Battler defender;

    private int turnCounter;

    public Battle(Battler player1, Battler player2, IGenerationRuleset ruleset) {
        this.player1 = player1;
        this.player2 = player2;
        this.ruleset = ruleset;
        this.turnCounter = 1;
    }

    public Battler getPlayer1() {
        return player1;
    }

    public Battler getPlayer2() {
        return player2;
    }

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
