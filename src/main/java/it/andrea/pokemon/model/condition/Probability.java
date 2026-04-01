package it.andrea.pokemon.model.condition;

public class Probability<T> implements ICondition<T> {

    private final double probability;

    private Probability(double probability) {
        this.probability = probability;
    }

    public static <T> Probability<T> of(double probability) {
        return new Probability<>(probability);
    }

    @Override
    public boolean check(T t) {
        return Math.random() < probability;
    }

}
