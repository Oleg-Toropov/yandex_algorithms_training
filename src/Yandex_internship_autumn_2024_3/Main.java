package Yandex_internship_autumn_2024_3;
// НЕ КОПИРОВАТЬ НЕ  ПРОХОДИТ ПО ВРЕМЕНИ
//////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.util.*;

public class Main {
    private static final int M = 3;
    private static boolean canBeInIntersection(int event, Map<Integer, Integer> map1, Map<Integer, Integer> map2) {
        return map1.getOrDefault(event, 0) > 0 && map2.getOrDefault(event, 0) > 0;
    }

    private static void decreaseCount(int event, Map<Integer, Integer> map) {
        if (map.containsKey(event)) {
            map.put(event, map.get(event) - 1);
            if (map.get(event) == 0) {
                map.remove(event);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] events = new int[3][n];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < n; j++) {
                events[i][j] = scanner.nextInt();
            }
        }

        scanner.close();

        Map<Integer, Integer> mapA = new HashMap<>();
        Map<Integer, Integer> mapB = new HashMap<>();
        Map<Integer, Integer> mapC = new HashMap<>();

        for (int i = 0; i < n; i++) {
            mapA.put(events[0][i], mapA.getOrDefault(events[0][i], 0) + 1);
            mapB.put(events[1][i], mapB.getOrDefault(events[1][i], 0) + 1);
            mapC.put(events[2][i], mapC.getOrDefault(events[2][i], 0) + 1);
        }

        boolean[] removed = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (!canBeInIntersection(events[0][i], mapB, mapC) ||
                    !canBeInIntersection(events[1][i], mapA, mapC) ||
                    !canBeInIntersection(events[2][i], mapA, mapB)) {
                queue.add(i);
                removed[i] = true;
            }
        }

        while (!queue.isEmpty()) {
            int index = queue.poll();

            decreaseCount(events[0][index], mapA);
            decreaseCount(events[1][index], mapB);
            decreaseCount(events[2][index], mapC);

            for (int i = 0; i < n; i++) {
                if (!removed[i] &&
                        (!canBeInIntersection(events[0][i], mapB, mapC) ||
                                !canBeInIntersection(events[1][i], mapA, mapC) ||
                                !canBeInIntersection(events[2][i], mapA, mapB))) {
                    queue.add(i);
                    removed[i] = true;
                }
            }
        }

        int removedYears = 0;
        for (int i = 0; i < n; i++) {
            if (removed[i]) {
                removedYears++;
            }
        }

        System.out.println(removedYears);
    }
}