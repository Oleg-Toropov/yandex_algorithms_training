package Yandex_coderun_008;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // Инициализация списка смежности графа
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // Чтение ребер
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
        }
        scanner.close();

        boolean[] visited = new boolean[n + 1];
        List<List<Integer>> components = new ArrayList<>();

        // Обход всех вершин для определения компонент связности
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                Deque<Integer> stack = new ArrayDeque<>();
                stack.push(i);
                visited[i] = true;

                // DFS для нахождения всех вершин в компоненте связности
                while (!stack.isEmpty()) {
                    int current = stack.pop();
                    component.add(current);
                    for (int neighbor : adjacencyList.get(current)) {
                        if (!visited[neighbor]) {
                            visited[neighbor] = true;
                            stack.push(neighbor);
                        }
                    }
                }
                components.add(component);
            }
        }

        System.out.println(components.size());
        for (List<Integer> component : components) {
            System.out.println(component.size());
            for (int vertex : component) {
                System.out.print(vertex + " ");
            }
            System.out.println();
        }
    }
}
