package it.andrea.pokemon.factory.gen1.moves;

import it.andrea.pokemon.battle.Battle;
import it.andrea.pokemon.model.attempt.Attempt;
import it.andrea.pokemon.model.condition.Probability;
import it.andrea.pokemon.model.effect.StandardDamage;
import it.andrea.pokemon.model.move.IMove;
import it.andrea.pokemon.model.move.Move;
import it.andrea.pokemon.model.number.Exactly;
import it.andrea.pokemon.utils.DamageCategory;
import it.andrea.pokemon.utils.PokemonType;

import java.util.Map;
import java.util.function.Supplier;

public class Gen1NormalMoves {

    public static void register(Map<String, Supplier<IMove>> registry) {
        registry.put("Tackle", Gen1NormalMoves::createTackle);
    }

    public static IMove createTackle() {
        return Move.of(
                "Tackle",
                PokemonType.NORMAL,
                Attempt.of(
                        Probability.of(0.95),
                        StandardDamage.of(
                                PokemonType.NORMAL,
                                DamageCategory.PHYSICAL,
                                new Exactly(40),
                                Battle::getDefender)
                )
        );
    }

}
