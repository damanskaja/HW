import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        // Создаем и заполняем лист
        List<Integer> myList = new ArrayList<>();
        for (int i = 1; i <= 10000000; i++) {
            myList.add(i);
        }

        // Вариант 1: Используем for-each
        long startTime = System.currentTimeMillis();
        for (Integer temp : myList) {
            // Здесь ничего не делаем, просто перебираем элементы
        }
        long endTime = System.currentTimeMillis();
        System.out.println("For-each: " + (endTime - startTime) + " мс");

        // Вариант 2: Используем классический for
        startTime = System.currentTimeMillis();
        for (int i = 0; i < myList.size(); i++) {
            Integer temp = myList.get(i);
            // Здесь ничего не делаем, просто перебираем элементы
        }
        endTime = System.currentTimeMillis();
        System.out.println("Classic for: " + (endTime - startTime) + " мс");

        // Вариант 3: Используем классический for с размером листа в отдельной переменной
        int size = myList.size();
        startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            Integer temp = myList.get(i);
            // Здесь ничего не делаем, просто перебираем элементы
        }
        endTime = System.currentTimeMillis();
        System.out.println("Classic for with separate size variable: " + (endTime - startTime) + " мс");

        // Вариант 4: Используем классический for с обратным порядком перебора
        startTime = System.currentTimeMillis();
        for (int i = myList.size() - 1; i >= 0; i--) {
            Integer temp = myList.get(i);
            // Здесь ничего не делаем, просто перебираем элементы с конца
        }
        endTime = System.currentTimeMillis();
        System.out.println("Classic for with reverse order: " + (endTime - startTime) + " мс");

        // Вариант 5: Используем Iterator
        startTime = System.currentTimeMillis();
        Iterator<Integer> iterator = myList.iterator();
        while (iterator.hasNext()) {
            Integer temp = iterator.next();
            // Здесь ничего не делаем, просто перебираем элементы
        }
        endTime = System.currentTimeMillis();
        System.out.println("Iterator: " + (endTime - startTime) + " мс");

        // Вариант 6: Используем ListIterator с обратным порядком перебора
        startTime = System.currentTimeMillis();
        ListIterator<Integer> listIterator = myList.listIterator(myList.size());
        while (listIterator.hasPrevious()) {
            Integer temp = listIterator.previous();
            // Здесь ничего не делаем, просто перебираем элементы с конца
        }
        endTime = System.currentTimeMillis();
        System.out.println("ListIterator with reverse order: " + (endTime - startTime) + " мс");
    }
}

