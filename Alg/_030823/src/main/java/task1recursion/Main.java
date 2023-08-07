package task1recursion;

public class Main {
    public static int sumDivisibleByM(int n, int m) {
        if (n == 0) {
            return 0;
        }
        int current = n % m == 0 ? n : 0;
        return current + sumDivisibleByM(n - 1, m);
    }

    public static void main(String[] args) {
        int n = 10; // Диапазон от 1 до 10
        int m = 3; // Числа делятся на 3
        int result = sumDivisibleByM(n, m);
        System.out.println("Сумма чисел, которые делятся на " + m + " в диапазоне от 1 до " + n + ": " + result);
    }
}
