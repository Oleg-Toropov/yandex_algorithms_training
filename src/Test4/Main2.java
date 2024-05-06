package Test4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Создание объекта Scanner для считывания ввода с консоли
        int n = scanner.nextInt();                // Чтение количества городов
        int[][] cities = new int[n][2];           // Массив для хранения координат городов
        for (int i = 0; i < n; i++) {
            cities[i][0] = scanner.nextInt();    // Чтение координаты x для города i
            cities[i][1] = scanner.nextInt();    // Чтение координаты y для города i
        }
        int k = scanner.nextInt();               // Чтение максимального расстояния, которое можно преодолеть без дозаправки
        int start = scanner.nextInt() - 1;       // Чтение начального города и корректировка индекса на базе 0
        int end = scanner.nextInt() - 1;         // Чтение конечного города и корректировка индекса на базе 0

        Queue<Integer> queue = new LinkedList<>();  // Создание очереди для BFS
        queue.add(start);                          // Добавление начального города в очередь
        boolean[] visited = new boolean[n];        // Массив для отслеживания посещенных городов
        visited[start] = true;                     // Отметка начального города как посещенного
        int[] dist = new int[n];                   // Массив для хранения минимального количества шагов до каждого города
        Arrays.fill(dist, Integer.MAX_VALUE);      // Инициализация массива большими значениями
        dist[start] = 0;                           // Начальное расстояние до самого себя равно 0

        while (!queue.isEmpty()) {                 // Пока очередь не пуста, продолжаем обход
            int current = queue.poll();            // Извлечение текущего города из очереди
            for (int i = 0; i < n; i++) {          // Перебор всех городов для проверки возможности перехода
                int distance = Math.abs(cities[current][0] - cities[i][0]) + Math.abs(cities[current][1] - cities[i][1]);  // Вычисление манхэттенского расстояния
                if (!visited[i] && distance <= k) {  // Если город не посещен и можно до него доехать
                    visited[i] = true;             // Отметить город как посещенный
                    queue.add(i);                  // Добавить город в очередь

                    dist[i] = dist[current] + 1;   // Обновить расстояние до города
                    System.out.println(Arrays.toString(dist));
                    System.out.println(Arrays.toString(visited));
                }
            }
        }

        int result = dist[end] == Integer.MAX_VALUE ? -1 : dist[end];  // Вернуть -1, если путь не найден, иначе минимальное расстояние
        System.out.println(result);  // Вывод результата минимального расстояния
    }
}

