package Yandex_coderun_007;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<List<Integer>> adjList = new ArrayList<>(n); // Создание списка смежности для графа
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>()); // Инициализация списка смежности для каждой вершины
        }

        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt() - 1; // Чтение вершины u, преобразование в 0-базированный индекс
            int v = scanner.nextInt() - 1; // Чтение вершины v, преобразование в 0-базированный индекс
            adjList.get(u).add(v); // Добавление v в список смежности u
            adjList.get(v).add(u); // Добавление u в список смежности v, т.к. граф неориентированный
        }

        System.out.println(adjList);

        boolean[] visited = new boolean[n]; // Массив посещенных вершин
        List<Integer> component = new ArrayList<>(); // Список для хранения компоненты связности

        // Функция для поиска в глубину (DFS)
        Deque<Integer> stack = new ArrayDeque<>(); // Стек для хранения вершин при обходе
        stack.push(0); // Начать DFS с вершины 1 (0 в 0-индексированной нотации)
        visited[0] = true; // Помечаем вершину 0 как посещенную

        while (!stack.isEmpty()) { // Пока стек не пуст
            int vertex = stack.pop(); // Извлечение вершины из стека
            component.add(vertex + 1); // Добавление вершины в компоненту связности
            for (int adjVertex : adjList.get(vertex)) { // Обход всех соседних вершин
                if (!visited[adjVertex]) { // Если вершина не была посещена
                    visited[adjVertex] = true; // Пометить как посещенную
                    stack.push(adjVertex); // Добавить вершину в стек
                }
            }
        }

        Collections.sort(component);

        System.out.println(component.size());
        for (int vertex : component) {
            System.out.print(vertex + " ");
        }
    }
}
