package task2;

import java.util.HashMap;
import java.util.Map;

public class SequenceCalculator {

    // Мап для мемоизации уже вычисленных значений
    private static Map<Integer, Integer> memo = new HashMap<>();

    public static int calculateSequence(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int result;
        if (n % 2 == 0) {
            result = calculateSequence(n / 2) + calculateSequence(n / 2 - 1);
        } else {
            result = calculateSequence(n / 2) - calculateSequence(n / 2 - 1);
        }

        // Сохраняем результат вычисления в мап
        memo.put(n, result);

        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        int nthTerm = calculateSequence(n);
        System.out.println("a(" + n + ") = " + nthTerm);
    }
}
