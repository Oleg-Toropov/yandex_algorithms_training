package Yandex_internship_2024_4; // НЕ КОПИРОВАТЬ
//////////////////////////////////////////////////////////////////////////////////////////////////////////
// ПРОСТОЙ СПОСОБ РЕШЕНИЯ - НЕ ПРОХОДИТ ЛИМИТ ПО ВРЕМЕНИ

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class Main {
    static class State {
        int position;
        int direction;

        public State(int position, int direction) {
            this.position = position;
            this.direction = direction;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String commands = scanner.nextLine();
        scanner.close();

        Set<Integer> finalPositions = new HashSet<>();

        State[] states = new State[n + 1];
        states[0] = new State(0, 1);



        for (int i = 0; i < n; i++) {
            char command = commands.charAt(i);
            State prev = states[i];
            int newPos = prev.position;
            int newDir = prev.direction;

            if (command == 'F') {
                newPos += newDir;
            } else if (command == 'L') {
                newDir = -1;
            } else if (command == 'R') {
                newDir = 1;
            }

            states[i + 1] = new State(newPos, newDir);
        }

        for (int i = 0; i < n; i++) {
            State original = states[i];
            char[] possibleCommands = {'F', 'L', 'R'};

            for (char newCommand : possibleCommands) {
                if (commands.charAt(i) != newCommand) {
                    int position = original.position;
                    int direction = original.direction;


                    if (newCommand == 'F') {
                        position += direction;
                    } else if (newCommand == 'L') {
                        direction = -1;
                    } else if (newCommand == 'R') {
                        direction = 1;
                    }


                    for (int j = i + 1; j < n; j++) {
                        char command = commands.charAt(j);
                        if (command == 'F') {
                            position += direction;
                        } else if (command == 'L') {
                            direction = -1;
                        } else if (command == 'R') {
                            direction = 1;
                        }
                    }

                    finalPositions.add(position);
                }
            }
        }

        System.out.println(finalPositions.size());
    }
}
