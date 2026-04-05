package it.andrea.pokemon.factory.gen1;

import it.andrea.pokemon.factory.IMoveRegistry;
import it.andrea.pokemon.factory.gen1.moves.Gen1GroundMoves;
import it.andrea.pokemon.factory.gen1.moves.Gen1NormalMoves;
import it.andrea.pokemon.model.move.IMove;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class Gen1MoveRegistry implements IMoveRegistry {

    private final Map<String, Supplier<IMove>> moveMap = new HashMap<>();

    public Gen1MoveRegistry() {
        Gen1NormalMoves.register(moveMap);
        Gen1GroundMoves.register(moveMap);
    }

    @Override
    public IMove getMove(String name) {
        Supplier<IMove> moveSupplier = moveMap.get(name.toLowerCase());
        if (moveSupplier == null) {
            throw new IllegalArgumentException("Move not found: " + name);
        }
        return moveSupplier.get();
    }

}
