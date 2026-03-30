package it.andrea.pokemon.model.attempt;

import it.andrea.pokemon.battle.Battle;

import java.util.Collection;

public class Cascade implements IAttempt {

    private final Collection<IAttempt> attempts;

    public Cascade(Collection<IAttempt> attempts) {
        this.attempts = attempts;
    }

    @Override
    public void execute(Battle battle) {
        for (IAttempt attempt : attempts) {
            attempt.execute(battle);
        }
    }
}
