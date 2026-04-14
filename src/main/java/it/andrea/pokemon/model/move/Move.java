package it.andrea.pokemon.model.move;

import it.andrea.pokemon.battle.Battle;
import it.andrea.pokemon.model.attempt.IAttempt;
import it.andrea.pokemon.utils.PokemonType;

public class Move implements IMove {

    private final String name;
    private final PokemonType type;
    private final IAttempt attempt;

    private Move(String name, PokemonType type, IAttempt attempt) {
        this.name = name;
        this.type = type;
        this.attempt = attempt;
    }

    public static Move of(String name, PokemonType type, IAttempt attempt) {
        return new Move(name, type, attempt);
    }

    public PokemonType getType() {
        return type;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void execute(Battle battle) {
        System.out.println(battle.getAttacker().getName() + " use " + name + "!");
        attempt.execute(battle);
    }
}
