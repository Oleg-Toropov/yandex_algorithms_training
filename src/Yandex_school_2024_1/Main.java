package Yandex_school_2024_1; // НЕ КОПИРОВАТЬ
//////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String user = sc.nextLine();
        sc.close();

        String result = (user.length() >= 8 && user.matches(".*\\d.*") && user.matches(".*[A-Z].*") &&
                user.matches(".*[a-z].*")) ? "YES" : "NO";

        System.out.println(result);
    }
}
