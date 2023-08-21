package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static int findKthElement(int[] arr1, int[] arr2, int k) {
        int m = arr1.length;
        int n = arr2.length;
        int i = 0, j = 0, count = 0;
        int result = 0;

        while (i < m && j < n) {
            if (arr1[i] < arr2[j]) {
                result = arr1[i];
                i++;
            } else {
                result = arr2[j];
                j++;
            }
            count++;

            if (count == k) {
                break;
            }
        }

        // If kth element is not yet found, continue from the remaining array
        while (i < m && count < k) {
            result = arr1[i];
            i++;
            count++;
        }

        while (j < n && count < k) {
            result = arr2[j];
            j++;
            count++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {100, 112, 256, 349, 770};
        int[] arr2 = {72, 86, 113, 119, 265, 445, 892};
        int k = 7;

        int result = findKthElement(arr1, arr2, k);
        System.out.println("The " + k + "th element is: " + result);
    }
}
