package Test1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine(); //ab
        String s2 = sc.nextLine(); //aabbccdd
        sc.close();

        int count = 0;

        for (int i = 0; i < s2.length(); i++) {
            if (s1.indexOf(s2.charAt(i)) >= 0) {
                count++;
            }
        }

        System.out.println(count);
    }
}