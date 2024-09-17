package Yandex_internship_autumn_2024_2;
// НЕ КОПИРОВАТЬ
//////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int b = scanner.nextInt();
        int[] a = new int[n];

        int indexB = -1;
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            if (a[i] == b) {
                indexB = i;
            }
        }

        scanner.close();

        Map<Integer, Integer> leftBalance = new HashMap<>();
        int balance = 0;
        leftBalance.put(balance, 1);

        for (int i = indexB - 1; i >= 0; i--) {
            if (a[i] > b) {
                balance++;
            } else if (a[i] < b) {
                balance--;
            }

            leftBalance.put(balance, leftBalance.getOrDefault(balance, 0) + 1);
        }

        balance = 0;
        int result = 0;

        for (int i = indexB; i < n; i++) {
            if (a[i] > b) {
                balance++;
            } else if (a[i] < b) {
                balance--;
            }

            result += leftBalance.getOrDefault(-balance, 0);
        }

        System.out.println(result);
    }
}

