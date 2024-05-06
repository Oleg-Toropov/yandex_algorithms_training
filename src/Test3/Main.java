package Test3;

import java.util.Scanner;

public class Main{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int prev = sc.nextInt();
        System.out.println(prev);

        for (int i = 1; i < n; i++){
            int current = sc.nextInt();
            if (prev != current) {
                System.out.println(current);
                prev = current;
            }
        }
        sc.close();
    }
}
