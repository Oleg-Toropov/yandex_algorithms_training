package Yandex_harb_9;
/*
Дан массив точек с целочисленными координатами (x, y). Определить, существует ли вертикальная прямая, делящая точки на 2
симметричных относительно этой прямой множества.
Note: Для удобства точку можно представлять не как массив [x, y], а как
объект {x, y}
4
1 1
3 1
2 1
4 1
 */

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] points = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                points[i][j] = sc.nextInt();
            }
        }
        sc.close();

        // Подсчёт суммы всех координат x
        double sumX = 0;
        for (int[] i : points) {
            sumX += i[0];
        }
        double centerX = sumX / points.length;  // Вычисление центральной точки (вероятной оси симметрии)

        // Создание множества точек для быстрой проверки наличия симметричной точки
        Set<String> pointSet = new HashSet<>();
        for (int[] i : points) {
            pointSet.add(Arrays.toString(i));
        }

        boolean isSymmetric = true;

        if (2 * centerX != Math.floor(2 * centerX)) {
            isSymmetric = false;
        } else {
            for (int[] i : points) {
                int[] symmetricPoint = {(int) (2 * centerX - i[0]), i[1]};
                if (!pointSet.contains(Arrays.toString(symmetricPoint))) {
                    isSymmetric = false;
                    break;
                }
            }
        }

        System.out.println(isSymmetric);
    }
}
