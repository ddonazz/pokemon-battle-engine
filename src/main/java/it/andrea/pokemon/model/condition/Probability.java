package it.andrea.pokemon.model.condition;

public class Probability<T> implements ICondition<T> {

    private final double probability;

    public Probability(double probability) {
        this.probability = probability;
    }

    @Override
    public boolean check(T t) {
        return Math.random() < probability;
    }

}
