package Yandex_internship_2024_2; // НЕ КОПИРОВАТЬ
//////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Q = sc.nextInt();
        sc.nextLine();

        String[] dictionary = new String[N];
        for (int i = 0; i < N; i++) {
            dictionary[i] = sc.nextLine();
        }

        int[] result = new int[Q];

        for (int i = 0; i < Q; i++) {
            int k = sc.nextInt();
            String prefix = sc.next();
            result[i] = findWord(dictionary, prefix, k);
        }

        sc.close();

        for (int i: result) {
            System.out.println(i);
        }
    }

    private static int findWord(String[] dictionary, String prefix, int k) {
        int left = 0;
        int right = dictionary.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (dictionary[middle].startsWith(prefix)) {

                if (middle == 0 || !dictionary[middle - 1].startsWith(prefix)) {
                    left = middle;
                    break;
                } else {
                    right = middle - 1;
                }

            } else if (dictionary[middle].compareTo(prefix) < 0) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        if (left < dictionary.length && dictionary[left].startsWith(prefix)) {

            int kIndex = left + k - 1;

            if (kIndex < dictionary.length && dictionary[kIndex].startsWith(prefix)) {
                return kIndex + 1;
            }
        }

        return -1;
    }
}
