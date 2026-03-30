package it.andrea.pokemon.model.number;

import it.andrea.pokemon.battle.Battle;

import java.util.Collection;

public class Weighted implements INumber {

    public record WeightedValue(double value, double weight) {
    }

    // value and its percentual weight
    private final Collection<WeightedValue> weights;
    private final double totalWeight;

    public Weighted(Collection<WeightedValue> weights) {
        if (weights == null || weights.isEmpty()) {
            throw new IllegalArgumentException("Weight collection cannot be null or empty");
        }
        this.weights = weights;
        this.totalWeight = weights.stream().mapToDouble(WeightedValue::weight).sum();

        if (this.totalWeight <= 0) {
            throw new IllegalArgumentException("Total weight must be greater than zero");
        }
    }

    @Override
    public double evaluate(Battle battle) {
        double random = Math.random() * totalWeight;
        double cumulativeWeight = 0.0;
        WeightedValue lastItem = null;

        for (WeightedValue item : weights) {
            lastItem = item;
            cumulativeWeight += item.weight();

            if (random < cumulativeWeight) {
                return item.value();
            }
        }

        return lastItem.value();
    }
}
