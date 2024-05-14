package Yandex_harb_1;
/*
Даны два массива: [1, 2, 3, 2, 0] и [5, 1, 2, 7, 3, 2]
Надо вернуть пересечение множеств [1, 2, 2, 3] (порядок неважен)
 */

import java.util.*;

public class MainV2 {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 2, 0};
        int[] array2 = {5, 1, 2, 7, 3, 2};
        Arrays.sort(array1);
        Arrays.sort(array2);

        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < array1.length && j < array2.length) {
            if (array1[i] < array2[j]) {
                i++;
            } else if (array1[i] > array2[j]) {
                j++;
            } else {
                result.add(array1[i]);
                i++;
                j++;
            }
        }

        System.out.println(result);
    }
}
