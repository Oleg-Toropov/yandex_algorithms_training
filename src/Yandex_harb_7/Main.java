package Yandex_harb_7;
/*
Дан отсортированный массив чисел а, индекс элемента index и целое число k. Необходимо вернуть в любом порядке k чисел из
массива, которые являются ближайшими по значению к элементу а[index].
find_k_closest(a={2,3,5,7,11}, index=3, k=2) -> {5,7}
3 2
2 3 5 7 11

find_k_closest(a={4,12,15,15,24}, index=1, k=3) -> {12,15,15}
1 3
4 12 15 15 24

find_k_closest(a={2,3,5,7,11}, index=2, k=2) -> {5,7} или {3,5}
2 2
2 3 5 7 11
 */


import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int index = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();

        String[] inputArray = sc.nextLine().split(" ");
        sc.close();

        int n = inputArray.length;

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(inputArray[i]);
        }

        List<Integer> result = new ArrayList<>();

        // Левый и правый указатели для поиска ближайших элементов
        int left = index - 1;
        int right = index + 1;

        // Добавляем сначала элемент a[index], если k > 0
        if (k > 0) {
            result.add(a[index]);
        }

        // Ищем оставшиеся k-1 ближайших элементов
        while (result.size() < k) {
            // Если левый указатель в пределах массива и (правый указатель вне массива или элемент слева ближе к a[index])
            if (left >= 0 && (right >= n || Math.abs(a[left] - a[index]) <= Math.abs(a[right] - a[index]))) {
                result.add(a[left]);
                left--;
            } else if (right < n) { // В противном случае, если правый указатель в пределах массива
                result.add(a[right]);
                right++;
            }
        }

        System.out.println(result);


    }
}
