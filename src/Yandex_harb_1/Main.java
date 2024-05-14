package Yandex_harb_1;
/*
Даны два массива: [1, 2, 3, 2, 0] и [5, 1, 2, 7, 3, 2]
Надо вернуть пересечение множеств [1, 2, 2, 3] (порядок неважен)
 */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 2, 0};
        int[] array2 = {5, 1, 2, 7, 3, 2};

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int i : array1) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        for (int i : array2) {
            if (map.containsKey(i) && map.get(i) > 0) {
                map.put(i, map.get(i) - 1);
                result.add(i);
            }
        }

        System.out.print(result);
    }
}
