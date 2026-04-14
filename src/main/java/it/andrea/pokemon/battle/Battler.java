package it.andrea.pokemon.battle;

import it.andrea.pokemon.model.move.IMove;
import it.andrea.pokemon.utils.PokemonType;
import it.andrea.pokemon.utils.StatType;
import it.andrea.pokemon.utils.StatusCondition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Battler {

    private final int level;
    private final PokemonStats stats;
    private final Map<StatType, Integer> statStages;
    private final List<IMove> moves;
    private String name;
    private List<PokemonType> types;
    private StatusCondition statusCondition;
    private int statusTurns;
    private int currentHp;

    public Battler(String name, List<PokemonType> types, int level, PokemonStats stats) {
        this.name = name;
        this.types = types;
        this.level = level;
        this.stats = stats;
        this.moves = new ArrayList<>();

        statusTurns = 0;
        statusCondition = StatusCondition.NONE;
        currentHp = stats.getMaxHp();

        statStages = Arrays.stream(StatType.values())
                .collect(Collectors.toMap(stat -> stat, stat -> 0));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PokemonType> getTypes() {
        return types;
    }

    public void setTypes(List<PokemonType> types) {
        this.types = types;
    }

    public PokemonStats getStats() {
        return stats;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public void setCurrentHp(int currentHp) {
        this.currentHp = Math.clamp(currentHp, 0, stats.getMaxHp());
    }

    public int getLevel() {
        return level;
    }

    public Map<StatType, Integer> getStatStages() {
        return Map.copyOf(statStages);
    }

    public void updateStatStages(StatType statType, int stage) {
        statStages.put(statType, Math.clamp(statStages.get(statType) + stage, -6, 6));
    }

    public StatusCondition getStatusCondition() {
        return statusCondition;
    }

    public void setStatusCondition(StatusCondition statusCondition) {
        if (this.statusCondition == StatusCondition.NONE || statusCondition == StatusCondition.NONE) {
            this.statusCondition = statusCondition;
            this.statusTurns = 0;
        }
    }

    public int getStat(StatType statType) {
        int baseValue = switch (statType) {
            case HP -> getStats().getMaxHp();
            case ATTACK -> getStats().getAttack();
            case DEFENSE -> getStats().getDefense();
            case SPECIAL_ATTACK -> getStats().getSpecialAttack();
            case SPECIAL_DEFENSE -> getStats().getSpecialDefense();
            case SPEED -> getStats().getSpeed();
            default -> throw new IllegalArgumentException("Stat not supported: " + statType);
        };

        if (statType == StatType.HP) {
            return baseValue;
        }

        int stage = statStages.getOrDefault(statType, 0);
        double multiplier = stage >= 0
                ? (2.0 + stage) / 2.0
                : 2.0 / (2.0 - stage);

        return Math.max(1, (int) Math.floor(baseValue * multiplier));
    }

    public void takeDamage(int damage) {
        if (damage < 0) return;
        setCurrentHp(this.currentHp - damage);
    }

    public void heal(int amount) {
        if (amount < 0) return;
        setCurrentHp(this.currentHp + amount);
    }

    public void incrementStatusTurn() {
        statusTurns++;
    }

    public List<IMove> getMoves() {
        return moves;
    }

    public void learnMove(IMove move) {
        if (moves.size() >= 4) {
            throw new IllegalStateException("A Pokemon can only have 4 moves");
        }
        moves.add(move);
    }

    public void removeMove(IMove move) {
        moves.remove(move);
    }
}
