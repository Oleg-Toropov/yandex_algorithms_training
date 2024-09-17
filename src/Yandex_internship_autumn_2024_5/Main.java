package Yandex_internship_autumn_2024_5;
// НЕ КОПИРОВАТЬ РЕШЕНИЕ НЕ ПРОХОДИТ ПО ПАМЯТИ
//////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        List<Integer> indexesOfWords = new ArrayList<>();
        boolean isEnd;
        int indexEnd = Integer.MAX_VALUE;
    }

    static class Trie {
        private final TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        private int charToIndex(char ch) {
            return ch - 'a';
        }

        public void insert(String word, int indexOfWord) {
            TrieNode current = root;
            for (char ch : word.toCharArray()) {
                int idx = charToIndex(ch);
                if (current.children[idx] == null) {
                    current.children[idx] = new TrieNode();
                }
                current = current.children[idx];
                current.indexesOfWords.add(indexOfWord);
            }
            current.isEnd = true;
            current.indexEnd = Math.min(current.indexEnd, indexOfWord);
        }

        public int searchForWordIndex(String query) {
            TrieNode current = root;
            for (char ch : query.toCharArray()) {
                int idx = charToIndex(ch);
                if (current.children[idx] == null) {
                    return -1;
                }
                current = current.children[idx];
            }
            return current.isEnd ? current.indexEnd : -1;
        }

        public int commonPrefix(String query, int currentWordIndex) {
            TrieNode current = root;
            int actions = 0;

            for (char ch : query.toCharArray()) {
                int idx = charToIndex(ch);
                if (current.children[idx] != null) {
                    current = current.children[idx];

                    if (currentWordIndex == -1) {
                        actions += current.indexesOfWords.size();
                    } else {
                        int index = binarySearch(current.indexesOfWords, currentWordIndex + 1);
                        if (index != -1) {
                            actions += index + 1;
                        } else {
                            break;
                        }
                    }
                } else {
                    break;
                }
            }
            return actions;
        }
    }

    private static int binarySearch(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        int resultIndex = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (list.get(mid) < target) {
                resultIndex = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return resultIndex;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        Trie trie = new Trie();

        for (int i = 0; i < n; i++) {
            trie.insert(sc.nextLine(), i);
        }

        int q = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < q; i++) {
            String query = sc.nextLine();

            int currentWordIndex = trie.searchForWordIndex(query);
            int actionsDuringWordIteration = (currentWordIndex == -1) ? n : currentWordIndex + 1;
            int actionsDuringLettersIteration = 0;

            actionsDuringLettersIteration += trie.commonPrefix(query, currentWordIndex);
            System.out.println(actionsDuringLettersIteration + actionsDuringWordIteration);
        }

        sc.close();
    }
}

/*
5
apple
app
application
banana
band
1
app

 */