package Yandex_school_2024_4; // НЕ КОПИРОВАТЬ
//////////////////////////////////////////////////////////////////////////////////////////////////////////
// Примечание: решение не проходит по лимиту времени!
//////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = reader.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int K = Integer.parseInt(firstLine[1]);

        String[] costStrings = reader.readLine().split(" ");
        int[] costs = new int[N];
        int[][] daysAndCosts = new int[N][2];

        for (int i = 0; i < N; i++) {
            int j = Integer.parseInt(costStrings[i]);
            costs[i] = j;
            daysAndCosts[i][0] = i;
            daysAndCosts[i][1] = j;
        }

        reader.close();

        Arrays.sort(daysAndCosts, (a, b) -> Integer.compare(a[1], b[1]));

        long totalCost = 0;
        int[] fishBought = new int[N];

        boolean[] covered = new boolean[N];

        for (int[] dayAndCost : daysAndCosts) {
            int currentDay = dayAndCost[0];

            if (fishBought[currentDay] < K) {
                int maxCoverDay = Math.min(N, currentDay + K);
                int countFish = 0;

                for (int i = currentDay; i < maxCoverDay; i++) {
                    if (!covered[i]) {
                        covered[i] = true;
                        countFish++;
                        if (countFish == K) {
                            break;
                        }
                    }
                }

                fishBought[currentDay] = countFish;
                totalCost += (long) countFish * costs[currentDay];
            }
        }

        StringBuilder output = new StringBuilder();
        output.append(totalCost).append("\n");
        for (int bought : fishBought) {
            output.append(bought).append(" ");
        }
        System.out.print(output.toString());
    }
}
