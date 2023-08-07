package task1cycle;

public class Main {
    public static int sumDivisibleByM(int n, int m) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (i % m == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int n = 10; // Диапазон от 1 до 10
        int m = 3; // Числа делятся на 3
        int result = sumDivisibleByM(n, m);
        System.out.println("Сумма чисел, которые делятся на " + m + " в диапазоне от 1 до " + n + ": " + result);
    }
}
