package FinalExamsFundamentalsModule;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ManOWar {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Integer> ships = Arrays.stream(input.nextLine().split(">")).map(e -> Integer.parseInt(e)).collect(Collectors.toList());
        List<Integer> warships = Arrays.stream(input.nextLine().split(">")).map(e -> Integer.parseInt(e)).collect(Collectors.toList());
        int health = Integer.parseInt(input.nextLine());
        while (true) {
            String command = input.nextLine();
            if (command.equals("Retire")) {
                int sumShips = 0;
                int sumWarShips = 0;
                for (int i : ships) {
                    sumShips += i;
                }
                for (int i : warships) {
                    sumWarShips += i;
                }
                System.out.printf("Pirate ship status: %d%n",sumShips);
                System.out.printf("Warship status: %d%n",sumWarShips);
                break;
            }
            if (command.contains("Fire ")) {
                command = command.replace("Fire ", "");
                int[] arr = Arrays.stream(command.split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
                int index = arr[0];
                int damage = arr[1];
                if (index >= 0 && index < warships.size()) {
                    int toSet = warships.get(index) - damage;
                    warships.set(index, toSet);
                    if (toSet <= 0) {
                        System.out.println("You won! The enemy ship has sunken.");
                        return;
                    }
                }
            } else if (command.contains("Defend ")) {
                command = command.replace("Defend ", "");
                int[] arr = Arrays.stream(command.split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
                int startIndex = arr[0];
                int endIndex = arr[1];
                int damage = arr[2];
                if (startIndex >= 0 && endIndex >=0 && endIndex < ships.size() && startIndex < ships.size()) {
                    for (int i = startIndex; i <= endIndex; i++) {
                        int toset = ships.get(i) - damage;
                        ships.set(i, toset);
                        if (toset <= 0) {
                            System.out.println("You lost! The pirate ship has sunken.");
                            return;
                        }
                    }
                }
            }else if (command.contains("Repair ")) {
                command = command.replace("Repair ", "");
                int[] arr = Arrays.stream(command.split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
                int index = arr[0];
                int heal = arr[1];
                if (index >=0 && index < ships.size()) {
                    int newHealth = ships.get(index) + heal;
                    if (newHealth <= health) {
                        ships.set(index, newHealth);
                    } else {
                        ships.set(index, health);
                    }
                }
            } else if (command.equals("Status")) {
                double check = health * 0.2;
                int count = 0;
                for (int i : ships) {
                    if (i < check) {
                        count++;
                    }
                }
                System.out.printf("%d sections need repair.%n",count);
            }
        }

    }
}
