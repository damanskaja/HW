package org.example;

import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // Массив уже отсортирован или пуст
        }
        int length = arr.length;
        int mid = length / 2;

        int[] left = new int[mid];
        int[] right = new int[length - mid];

        // Заполнение временных массивов
        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, length - mid);

        // Рекурсивная сортировка обоих подмассивов
        mergeSort(left);
        mergeSort(right);

        // Объединение отсортированных подмассивов
        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int leftLength = left.length;
        int rightLength = right.length;
        int i = 0, j = 0, k = 0;

        while (i < leftLength && j < rightLength) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < leftLength) {
            arr[k++] = left[i++];
        }

        while (j < rightLength) {
            arr[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {16, 15, 10, 4, 5, 6};
        System.out.println("Исходный массив: " + Arrays.toString(arr));


        mergeSort(arr);

        System.out.println("Отсортированный массив: " + Arrays.toString(arr));
    }
}
