public class Main {

    public static int findSingleElement(int[] arr) {
        int result = 0;
        for (int num : arr) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] sortedArray = {1, 1, 2, 2, 3, 3, 4, 4, 5}; // Пример отсортированного массива
        int singleElement = findSingleElement(sortedArray);
        System.out.println("Элемент, встречающийся один раз: " + singleElement);
    }
}

