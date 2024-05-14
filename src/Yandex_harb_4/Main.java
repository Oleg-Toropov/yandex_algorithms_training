package Yandex_harb_4;

/*
Дан массив из нулей и единиц. Нужно определить, какой максимальный по длине подинтервал единиц можно получить, удалив
ровно один элемент массива.
[1, 1, 0]
[1, 1, 0, 1, 1]
[1, 1, 0, 1, 1, 0, 1, 1, 1]
 */

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1};

        int currentOnes = 0;
        int prevOnes = 0;
        int maxOnes = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                currentOnes++;
            } else {
                maxOnes = Math.max(maxOnes, prevOnes + currentOnes);
                prevOnes = currentOnes;
                currentOnes = 0;
            }

        }

        maxOnes = Math.max(maxOnes, prevOnes + currentOnes);

        System.out.println(maxOnes);
    }
}

