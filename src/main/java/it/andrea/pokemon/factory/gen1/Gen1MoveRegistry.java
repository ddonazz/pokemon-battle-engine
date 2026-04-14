package it.andrea.pokemon.factory.gen1;

import it.andrea.pokemon.factory.IMoveRegistry;
import it.andrea.pokemon.factory.gen1.moves.Gen1FireMoves;
import it.andrea.pokemon.factory.gen1.moves.Gen1GrassMoves;
import it.andrea.pokemon.factory.gen1.moves.Gen1GroundMoves;
import it.andrea.pokemon.factory.gen1.moves.Gen1NormalMoves;
import it.andrea.pokemon.model.move.IMove;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class Gen1MoveRegistry implements IMoveRegistry {

    private static final IMoveRegistry INSTANCE = new Gen1MoveRegistry();

    private final Map<String, Supplier<IMove>> moveMap = new HashMap<>();

    private Gen1MoveRegistry() {
        Gen1NormalMoves.register(moveMap);
        Gen1FireMoves.register(moveMap);
        Gen1GrassMoves.register(moveMap);
        Gen1GroundMoves.register(moveMap);
    }

    public static IMoveRegistry getInstance() {
        return INSTANCE;
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
