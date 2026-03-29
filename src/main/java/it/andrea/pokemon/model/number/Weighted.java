package it.andrea.pokemon.model.number;

import it.andrea.pokemon.battle.Battle;

import java.util.Collection;
import java.util.Map;

public class Weighted implements INumber {

    // value and its percentual weight
    private final Collection<Map.Entry<Double, Double>> weights;

    public Weighted(Collection<Map.Entry<Double, Double>> weights) {
        this.weights = weights;
    }


    @Override
    public double evaluate(Battle battle) {
        double totalWeight = weights.stream().mapToDouble(Map.Entry::getValue).sum();
        double random = Math.random() * totalWeight;
        double cumulativeWeight = 0.0;

        for (Map.Entry<Double, Double> entry : weights) {
            cumulativeWeight += entry.getValue();
            if (random < cumulativeWeight) {
                return entry.getKey();
            }
        }

        return weights.stream().reduce((first, second) -> second).orElseThrow().getKey();
    }
}
