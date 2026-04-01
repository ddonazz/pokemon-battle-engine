package it.andrea.pokemon.factory;

import it.andrea.pokemon.model.move.IMove;
import it.andrea.pokemon.model.number.INumber;

public interface IMoveRegistry {

    IMove getMove(String name);

    INumber getDamageFormula();

}
