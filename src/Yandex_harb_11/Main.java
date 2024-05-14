package Yandex_harb_11;
/*
Дан список интов и число-цель. Нужно найти такой range, чтобы сумма его элементов давала число-цель.
elements = [1, -3, 4, 5]
target = 9
result = range(2, 4) # потому что elements[2] + elements[3] == target
 */

import java.util.*;


public class Main {
    public static void main(String[] args) {
        int[] elements = {1, -3, 4, 5};
        int target = 9;

        // Хеш-таблица для хранения сумм на префиксах и их индексов
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);  // Сумма 0 достигается перед началом массива

        int currentSum = 0;
        boolean rangeFound = false;

        for (int i = 0; i < elements.length; i++) {
            currentSum += elements[i];  // Обновляем текущую сумму

            // Проверяем, есть ли в хеш-таблице сумма, вычитая из текущей суммы целевую сумму
            if (map.containsKey(currentSum - target)) {
                // Если такая сумма найдена, выводим найденный диапазон
                System.out.println("Range: (" + (map.get(currentSum - target) + 1) + ", " + i + ")");
                rangeFound = true;
                break;
            }

            // Если текущая сумма еще не встречалась, сохраняем ее в хеш-таблицу
            map.putIfAbsent(currentSum, i);
        }

        // Если диапазон не найден, выводим соответствующее сообщение
        if (!rangeFound) {
            System.out.println("No range found.");
        }
    }

}
