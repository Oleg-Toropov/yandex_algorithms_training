package Yandex_harb_13;
/*
Перенести нули в конец массива, сохранив порядок остальных элементов
[1,0,8,9] → [1,8,9,0]
 */

public class Main {

    public static void main(String[] args) {
        int[] array = {1,0,8,9};

        if (array == null || array.length == 0) {
            return;
        }

        int insert = 0;

        for (int i: array) {
            if (i != 0) {
                array[insert] = i;
                insert++;
            }
        }

        while (insert < array.length) {
            array[insert] = 0;
            insert++;
        }

        for (int i : array) {
            System.out.print(i + " ");
        }

    }
}