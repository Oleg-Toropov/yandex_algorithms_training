package Yandex_harb_3;

/*
Дан список интов, повторяющихся элементов в списке нет. Нужно преобразовать это множество в строку, сворачивая соседние
по числовому ряду числа в диапазоны. Примеры:
[1,4,5,2,3,9,8,11,0] => "0-5,8-9,11"
[1,4,3,2] => "1-4"
[1,4] => "1,4"
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 4, 5, 2, 3, 9, 8, 11, 0};
        Arrays.sort(array);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            int start = array[i];

            if (i + 1 < array.length && start == array[i + 1] - 1) {
                while (array[i] == array[i + 1] - 1) {
                    i++;
                }
                int end = array[i];
                result.append(start + "-" + end + ",");

            } else {
                result.append(start + ",");

            }
        }

        result.deleteCharAt(result.length() - 1);
        System.out.println(result);
    }
}