package Yandex_coderun_009;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        sc.close();

        int[] colors = new int[n + 1];
        Arrays.fill(colors, -1);

        boolean isBipartite = true;

        OUTER: for (int i = 1; i <= n; i++) {
            if (colors[i] == -1) {
                // Использование стека для реализации DFS
                Deque<Integer> stack = new ArrayDeque<>();
                stack.push(i);
                colors[i] = 0; // Начальная окраска

                while (!stack.isEmpty()) {
                    int v = stack.pop();
                    for (int u : graph.get(v)) {
                        if (colors[u] == -1) { // Если вершина не окрашена
                            colors[u] = 1 - colors[v]; // Окрашиваем в противоположный цвет
                            stack.push(u);
                        } else if (colors[u] == colors[v]) { // Если соседняя вершина окрашена в тот же цвет
                            isBipartite = false;
                            break OUTER;
                        }
                    }
                }
            }
        }

        System.out.println(isBipartite ? "YES" : "NO");
    }
}

