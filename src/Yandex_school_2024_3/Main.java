package Yandex_school_2024_3; // НЕ КОПИРОВАТЬ
//////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> moves = new HashMap<>();
        String result = "Draw";
        int movesAfterWin = 0;

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();

            String rc = r + " " + c;
            int player = (i % 2 == 0) ? 1 : 2;
            moves.put(rc, player);

            if (result.equals("Draw") && hasWin(r, c, player, moves)) {
                result = (player == 1) ? "First" : "Second";
                movesAfterWin = n - (i + 1);
            }
        }
        sc.close();

        if (movesAfterWin > 0) {
            result = "Inattention";
        }

        System.out.println(result);
    }

    private static final int[] X = {0, 1, 1, -1};
    private static final int[] Y = {1, 0, 1, 1};

    private static int countMoves(int r, int c, int x, int y, int player, Map<String, Integer> moves) {
        int count = 0;
        while (true) {
            r += x;
            c += y;
            if (moves.getOrDefault(r + " " + c, -1) == player) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    private static boolean hasWin(int r, int c, int player, Map<String, Integer> moves) {

        for (int i = 0; i < 4; i++) {
            int count = 1;
            count += countMoves(r, c, X[i], Y[i], player, moves);
            count += countMoves(r, c, -X[i], -Y[i], player, moves);
            if (count == 5) {
                return true;
            }
        }
        return false;
    }
}
