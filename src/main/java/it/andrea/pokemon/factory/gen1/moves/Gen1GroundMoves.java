package it.andrea.pokemon.factory.gen1.moves;

import it.andrea.pokemon.battle.Battle;
import it.andrea.pokemon.model.attempt.Attempt;
import it.andrea.pokemon.model.condition.GreaterThanOrEqual;
import it.andrea.pokemon.model.condition.HasElement;
import it.andrea.pokemon.model.condition.Not;
import it.andrea.pokemon.model.condition.Probability;
import it.andrea.pokemon.model.effect.OneHitKnockOut;
import it.andrea.pokemon.model.move.IMove;
import it.andrea.pokemon.model.move.Move;
import it.andrea.pokemon.model.number.TargetStat;
import it.andrea.pokemon.utils.PokemonType;
import it.andrea.pokemon.utils.StatType;

import java.util.Map;
import java.util.function.Supplier;

public class Gen1GroundMoves {

    public static void register(Map<String, Supplier<IMove>> registry) {
        registry.put("fissure", Gen1GroundMoves::createFissure);
    }

    private static IMove createFissure() {
        return Move.of(
                        "Fissure",
                        PokemonType.GROUND,
                        Attempt.of(
                                Probability.of(0.3),
                                new OneHitKnockOut(Battle::getDefender)
                        )
                )
                .withPrecondition(
                        new GreaterThanOrEqual(
                                new TargetStat(Battle::getAttacker, StatType.SPEED),
                                new TargetStat(Battle::getDefender, StatType.SPEED)
                        )
                )
                .withApplicability(
                        new Not<>(new HasElement(PokemonType.FLYING))
                );
    }
}
