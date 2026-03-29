package it.andrea.pokemon;

import it.andrea.pokemon.model.attempt.Attempt;
import it.andrea.pokemon.model.condition.Probability;
import it.andrea.pokemon.model.effect.FormulaDamage;
import it.andrea.pokemon.model.move.Move;
import it.andrea.pokemon.model.number.Exactly;
import it.andrea.pokemon.utils.PokemonType;

public class Main {

    public static void main(String[] args) {
        Move tackle = new Move(
                "Tackle",
                PokemonType.NORMAL,
                new Attempt(
                        new Probability<>(0.95),
                        new FormulaDamage(
                                new Exactly(40)
                        )
                )
        );
    }
}
