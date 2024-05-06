package Yandex_preparing_for_the_interview_2024_6;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] cities = new int[n][2];
        for (int i = 0; i < n; i++) {
            cities[i][0] = sc.nextInt();
            cities[i][1] = sc.nextInt();
        }

        int k = sc.nextInt();
        int start = sc.nextInt() - 1;
        int end = sc.nextInt() - 1;
        sc.close();

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        int[] numberOfRoads = new int[n];
        Arrays.fill(numberOfRoads, Integer.MAX_VALUE);
        numberOfRoads[start] = 0;

        boolean[] visited = new boolean[n];
        visited[start] = true;


        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    int distance = Math.abs(cities[current][0] - cities[i][0]) + Math.abs(cities[current][1] - cities[i][1]);

                    if (distance <= k) {
                        visited[i] = true;
                        queue.add(i);
                        numberOfRoads[i] = numberOfRoads[current] + 1;
                    }
                }
            }
        }

        int result = (numberOfRoads[end] == Integer.MAX_VALUE)? -1: numberOfRoads[end];
        System.out.println(result);
    }
}
