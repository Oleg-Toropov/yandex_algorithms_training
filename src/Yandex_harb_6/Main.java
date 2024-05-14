package Yandex_harb_6;
/*
Sample Input ["eat", "tea", "tan", "ate", "nat", "bat"]
Sample Output [ ["ate", "eat", "tea"], ["nat", "tan"], ["bat"] ]
eat tea tan ate nat bat
Т.е. сгруппировать слова по "общим буквам".

 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();
        String[] words = input.split(" ");


        Map<String, List<String>> map = new HashMap<>();
        for (String s : words) {
            char[] characters = s.toCharArray();
            Arrays.sort(characters);
            String sorted = new String(characters);
            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(s);
        }

        List<List<String>> result = new ArrayList<>(map.values());
        System.out.println(result);
    }
}
