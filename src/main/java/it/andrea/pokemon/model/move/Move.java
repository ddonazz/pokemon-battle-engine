package it.andrea.pokemon.model.move;

import it.andrea.pokemon.battle.Battle;
import it.andrea.pokemon.model.attempt.IAttempt;
import it.andrea.pokemon.utils.PokemonType;

public class Move implements IMove {

    private String name;
    private PokemonType type;
    private IAttempt attempt;

    public Move(String name, PokemonType type, IAttempt attempt) {
        this.name = name;
        this.type = type;
        this.attempt = attempt;
    }

    @Override
    public void execute(Battle battle) {
        System.out.println(battle.getAttacker().getName() + " use " + name + "!");
        attempt.execute(battle);
    }
}
