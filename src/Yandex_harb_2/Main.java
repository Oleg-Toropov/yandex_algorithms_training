package Yandex_harb_2;

/*
Дана строка (возможно, пустая), состоящая из букв A-Z: AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBB
Нужно написать функцию RLE, которая на выходе даст строку вида: A4B3C2XYZD4E3F3A6B28
И сгенерирует ошибку, если на вход пришла невалидная строка.
Пояснения: Если символ встречается 1 раз, он остается без изменений;
Если символ повторяется более 1 раза, к нему добавляется количество повторений.
 */

public class Main {

    public static void main(String[] args) {

        String st = "AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBB";

        if (!st.matches("[A-Z]*")) {
            System.out.println("Input string contains invalid characters");
            return;
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < st.length(); i++) {
            int count = 1;

            while (i + 1 < st.length() && st.charAt(i) == st.charAt(i + 1)) {
                count++;
                i++;
            }

            result.append(st.charAt(i));

            if (count > 1) {
                result.append(count);
            }
        }

        System.out.println(result.toString());

    }
}
