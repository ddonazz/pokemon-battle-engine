package it.andrea.pokemon.factory;

import it.andrea.pokemon.model.move.IMove;

public interface IMoveRegistry {

    IMove getMove(String name);

}
