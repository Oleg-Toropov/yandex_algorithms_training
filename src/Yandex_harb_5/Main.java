package Yandex_harb_5;
/*
Даны даты заезда и отъезда каждого гостя. Для каждого гостя дата заезда строго раньше даты отъезда (то есть каждый гость
останавливается хотя бы на одну ночь). В пределах одного дня считается, что сначала старые гости выезжают, а затем
въезжают новые. Найти максимальное число постояльцев, которые одновременно проживали в гостинице (считаем, что измерение
количества постояльцев происходит в конце дня).
sample = [ (1, 2), (1, 3), (2, 4), (2, 3), ]
4
1 2
1 3
2 4
2 3
 */

import java.util.*;

public class Main {
    static class Event {
        int date;
        int type;

        Event(int date, int type) {
            this.date = date;
            this.type = type;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();

        List<Event> events = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            events.add(new Event(x, 1));  // Заезд
            events.add(new Event(y, -1)); // Отъезд
        }
        sc.close();

        events.sort((a, b) -> {
            if (a.date == b.date) {
                return a.type - b.type; // отъезды (-1) перед заездами (+1) в один и тот же день
            }
            return a.date - b.date;
        });

        int currentGuests = 0;
        int maxGuests = 0;

        for(Event event: events) {
            currentGuests += event.type;
            if (currentGuests > maxGuests) {
                maxGuests = currentGuests;
            }
        }

        System.out.println(maxGuests);
    }
}
