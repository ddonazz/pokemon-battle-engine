package it.andrea.pokemon.factory.gen1.moves;

import it.andrea.pokemon.battle.Battle;
import it.andrea.pokemon.model.attempt.Attempt;
import it.andrea.pokemon.model.condition.Probability;
import it.andrea.pokemon.model.effect.AttackStatChange;
import it.andrea.pokemon.model.effect.StandardDamage;
import it.andrea.pokemon.model.move.IMove;
import it.andrea.pokemon.model.move.Move;
import it.andrea.pokemon.model.number.Exactly;
import it.andrea.pokemon.utils.DamageCategory;
import it.andrea.pokemon.utils.PokemonType;
import it.andrea.pokemon.utils.StatType;

import java.util.Map;
import java.util.function.Supplier;

public class Gen1NormalMoves {

    public static void register(Map<String, Supplier<IMove>> registry) {
        registry.put("tackle", Gen1NormalMoves::createTackle);
        registry.put("scratch", Gen1NormalMoves::createScratch);
        registry.put("tail whip", Gen1NormalMoves::createTailWhip);
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

    public static IMove createScratch() {
        return Move.of(
                "Scratch",
                PokemonType.NORMAL,
                Attempt.of(
                        Probability.of(1.0),
                        StandardDamage.of(
                                PokemonType.NORMAL,
                                DamageCategory.PHYSICAL,
                                new Exactly(40),
                                Battle::getDefender)
                )
        );
    }

    public static IMove createTailWhip() {
        return Move.of(
                "Tail Whip",
                PokemonType.NORMAL,
                Attempt.of(
                        Probability.of(1.0),
                        new AttackStatChange(Battle::getDefender, new Exactly(-1), StatType.DEFENSE)
                )
        );
    }

}
