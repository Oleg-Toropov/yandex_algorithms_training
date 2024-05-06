package Test4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
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

        System.out.println(minDistance(cities, n, k, start, end));  // Вывод результата минимального расстояния
    }

    private static int minDistance(int[][] cities, int n, int k, int start, int end) {
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
                if (!visited[i] && canTravel(cities[current], cities[i], k)) {  // Если город не посещен и можно до него доехать
                    visited[i] = true;             // Отметить город как посещенный
                    queue.add(i);                  // Добавить город в очередь
                    dist[i] = dist[current] + 1;   // Обновить расстояние до города
                }
            }
        }

        return dist[end] == Integer.MAX_VALUE ? -1 : dist[end];  // Вернуть -1, если путь не найден, иначе минимальное расстояние
    }

    private static boolean canTravel(int[] city1, int[] city2, int k) {
        int distance = Math.abs(city1[0] - city2[0]) + Math.abs(city1[1] - city2[1]);  // Вычисление манхэттенского расстояния
        return distance <= k;  // Возвращает true, если расстояние меньше или равно k
    }
}
