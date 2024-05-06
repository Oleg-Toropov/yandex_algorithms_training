package Yandex_internship_2024_5; // НЕ КОПИРОВАТЬ
//////////////////////////////////////////////////////////////////////////////////////////////////////////
// ПРОСТОЙ СПОСОБ РЕШЕНИЯ - НЕ ПРОХОДИТ ЛИМИТ ПО ВРЕМЕНИ

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static class TreeNode {
        Map<Character, TreeNode> children = new HashMap<>();
        int maxPopularity = -1;
        int index = -1;
    }

    private static final TreeNode root = new TreeNode();

    public static void insert(String word, int popularity, int index) {
        TreeNode node = root;
        if (popularity > root.maxPopularity) { // Обновляем корневой узел при необходимости
            root.maxPopularity = popularity;
            root.index = index;
        }
        for (char ch : word.toCharArray()) {
            node = node.children.computeIfAbsent(ch, k -> new TreeNode());
            if (node.maxPopularity < popularity) {
                node.maxPopularity = popularity;
                node.index = index;
            }
        }
    }

    public static int autocomplete(String prefix) {
        if (prefix.isEmpty()) {
            return root.index; // Возвращаем индекс для пустого префикса
        }
        TreeNode node = root;
        for (char ch : prefix.toCharArray()) {
            node = node.children.get(ch);
            if (node == null) {
                return -1;
            }
        }
        return node.index;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Q = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < N; i++) {
            String[] line = sc.nextLine().split(" ");
            String word = line[0];
            int popularity = Integer.parseInt(line[1]);
            insert(word, popularity, i + 1);
        }

        StringBuilder results = new StringBuilder();

        StringBuilder t = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            String query = sc.nextLine();
            if (query.startsWith("+")) {
                t.append(query.charAt(2));
            } else {
                t.deleteCharAt(t.length() - 1);
            }
            results.append(autocomplete(t.toString())).append("\n");
        }
        sc.close();

        System.out.println(results.toString());
    }
}

