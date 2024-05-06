package Yandex_preparing_for_the_interview_2024_4;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        generate("", 0, 0, n);
    }

    public static void generate(String st, int open, int close, int n) {

        if (st.length() == 2 * n) {
            System.out.println(st);
            return;
        }

        if (open < n) {
            generate(st + "(", open + 1, close, n);
        }

        if (close < open) {
            generate(st + ")", open, close + 1, n);
        }
    }
}

/*
Объяснение Java кода:
Метод generate: Это рекурсивный метод, который строит скобочные последовательности. Он принимает текущую
скобочную строку (cur), количество использованных открывающих (open) и закрывающих (closed) скобок,
а также максимальное допустимое количество открывающих скобок (n).
Условие if (cur.length() == 2 * n):
Если длина текущей строки достигает 2 * n, это означает, что последовательность полностью сформирована,
и мы можем её вывести.

Рекурсивные вызовы: Код делает рекурсивные вызовы для добавления новых скобок:
Открывающая скобка (: Добавляется, если количество открывающих скобок (open) меньше n.
Закрывающая скобка ): Добавляется, если количество закрывающих скобок (closed) меньше, чем открывающих (open).
Этот код должен корректно работать для генерации всех правильных скобочных последовательностей для заданного n.
 */
