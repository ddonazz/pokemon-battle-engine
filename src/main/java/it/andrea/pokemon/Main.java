package it.andrea.pokemon;

import it.andrea.pokemon.battle.Battle;
import it.andrea.pokemon.battle.Battler;
import it.andrea.pokemon.battle.PokemonStats;
import it.andrea.pokemon.factory.IMoveRegistry;
import it.andrea.pokemon.model.move.IMove;
import it.andrea.pokemon.model.rules.IGenerationRuleset;
import it.andrea.pokemon.utils.PokemonRules;
import it.andrea.pokemon.utils.PokemonType;
import it.andrea.pokemon.utils.StatType;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final Random RNG = new Random();

    public static void main(String[] args) {

        IGenerationRuleset generationRuleset = PokemonRules.GEN_1;
        IMoveRegistry moveRegistry = generationRuleset.getMoveRegistry();

        PokemonStats bulbasaurStats = PokemonStats.builder()
                .maxHp(45)
                .attack(49)
                .defense(49)
                .specialAttack(65)
                .specialDefense(65)
                .speed(45)
                .build();
        Battler player1 = new Battler("Bulbasaur", List.of(PokemonType.GRASS, PokemonType.POISON), 5, bulbasaurStats);
        player1.learnMove(moveRegistry.getMove("tackle"));
        player1.learnMove(moveRegistry.getMove("vine whip"));
        player1.learnMove(moveRegistry.getMove("tail whip"));

        PokemonStats charmenderStats = PokemonStats.builder()
                .maxHp(39)
                .attack(52)
                .defense(43)
                .specialAttack(60)
                .specialDefense(50)
                .speed(65)
                .build();
        Battler player2 = new Battler("Charmender", List.of(PokemonType.FIRE), 5, charmenderStats);
        player2.learnMove(moveRegistry.getMove("scratch"));
        player2.learnMove(moveRegistry.getMove("ember"));

        Battle battle = new Battle(player1, player2, generationRuleset);
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Start the battle ---");
        System.out.printf("%s vs %s%n", player1.getName(), player2.getName());
        printHp(player1, player2);

        while (player1.getCurrentHp() > 0 && player2.getCurrentHp() > 0) {
            System.out.printf("%nTurn %d%n", battle.getTurnCounter());

            List<Battler> turnOrder = getTurnOrder(player1, player2);
            for (Battler attacker : turnOrder) {
                Battler defender = attacker == player1 ? player2 : player1;
                if (attacker.getCurrentHp() <= 0 || defender.getCurrentHp() <= 0) {
                    continue;
                }

                battle.setAttacker(attacker);
                battle.setDefender(defender);

                IMove selectedMove = chooseMove(attacker, player1, scanner);
                selectedMove.execute(battle);
                printHp(player1, player2);
            }

            battle.setTurnCounter(battle.getTurnCounter() + 1);
        }

        Battler winner = player1.getCurrentHp() > 0 ? player1 : player2;
        System.out.printf("%n%s wins the battle!%n", winner.getName());
    }

    private static IMove chooseMove(Battler attacker, Battler humanPlayer, Scanner scanner) {
        List<IMove> moves = attacker.getMoves();

        if (attacker != humanPlayer) {
            return moves.get(RNG.nextInt(moves.size()));
        }

        System.out.printf("Choose the move for %s:%n", attacker.getName());
        for (int i = 0; i < moves.size(); i++) {
            System.out.printf("%d) %s%n", i + 1, moves.get(i).getName());
        }

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            try {
                int selected = Integer.parseInt(input);
                if (selected >= 1 && selected <= moves.size()) {
                    return moves.get(selected - 1);
                }
            } catch (NumberFormatException ignored) {
            }

            System.out.printf("Invalid input. Select a number between 1 and %d.%n", moves.size());
        }
    }

    private static List<Battler> getTurnOrder(Battler p1, Battler p2) {
        int speed1 = p1.getStat(StatType.SPEED);
        int speed2 = p2.getStat(StatType.SPEED);

        if (speed1 > speed2) {
            return List.of(p1, p2);
        }
        if (speed2 > speed1) {
            return List.of(p2, p1);
        }

        return List.of(p1, p2);
    }

    private static void printHp(Battler p1, Battler p2) {
        System.out.printf(
                "%s HP: %d/%d | %s HP: %d/%d%n",
                p1.getName(), p1.getCurrentHp(), p1.getStats().getMaxHp(),
                p2.getName(), p2.getCurrentHp(), p2.getStats().getMaxHp()
        );

    }
}
