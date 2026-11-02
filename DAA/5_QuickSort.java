/*
PRACTICAL: DETERMINISTIC AND RANDOMIZED QUICK SORT

AIM:
Implement Deterministic Quick Sort and Randomized Quick Sort and compare
their execution times.

JAVA PROGRAM:
*/

import java.util.*;

public class QuickSort {

    // Deterministic Quick Sort
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = arr[low];
            int i = low + 1;
            int j = high;

            while (i <= j) {
                while (i <= high && arr[i] <= pivot)
                    i++;

                while (arr[j] > pivot)
                    j--;

                if (i < j) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }

            int temp = arr[low];
            arr[low] = arr[j];
            arr[j] = temp;

            quickSort(arr, low, j - 1);
            quickSort(arr, j + 1, high);
        }
    }

    // Randomized Quick Sort
    static void randomQuickSort(int[] arr, int low, int high) {
        if (low < high) {
            Random random = new Random();
            int randomIndex = low + random.nextInt(high - low + 1);

            int temp = arr[randomIndex];
            arr[randomIndex] = arr[high];
            arr[high] = temp;

            int pivot = arr[high];
            int i = low - 1;

            for (int j = low; j < high; j++) {
                if (arr[j] <= pivot) {
                    i++;
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }

            temp = arr[i + 1];
            arr[i + 1] = arr[high];
            arr[high] = temp;

            int p = i + 1;

            randomQuickSort(arr, low, p - 1);
            randomQuickSort(arr, p + 1, high);
        }
    }

    // Main Program
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array elements: ");
        String line = sc.nextLine().trim();

        if (line.isEmpty()) {
            System.out.println("Please enter at least one element.");
            sc.close();
            return;
        }

        String[] values = line.split("\\s+");
        int[] arr = new int[values.length];

        for (int i = 0; i < values.length; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        int[] a = arr.clone();
        long start = System.nanoTime();
        quickSort(a, 0, a.length - 1);
        long end = System.nanoTime();

        System.out.println("Deterministic Quick Sort: " + Arrays.toString(a));
        System.out.println("Execution Time: " + (end - start) / 1_000_000.0 + " ms");

        int[] b = arr.clone();
        start = System.nanoTime();
        randomQuickSort(b, 0, b.length - 1);
        end = System.nanoTime();

        System.out.println("Randomized Quick Sort: " + Arrays.toString(b));
        System.out.println("Execution Time: " + (end - start) / 1_000_000.0 + " ms");

        sc.close();
    }
}

/*
I/P:
Enter array elements: 45 23 89 12 67 34 10

O/P:
Deterministic Quick Sort: [10, 12, 23, 34, 45, 67, 89]
Execution Time: (varies) ms

Randomized Quick Sort: [10, 12, 23, 34, 45, 67, 89]
Execution Time: (varies) ms

Deterministic Quick Sort:
Time – Best/Average: O(n log n), Worst: O(n²)
Space – O(n) worst-case recursion stack.

Randomized Quick Sort:
Time – Expected: O(n log n), Worst: O(n²)
Space – O(n) worst-case recursion stack.

RESULT:
Thus, Deterministic Quick Sort and Randomized Quick Sort were implemented
successfully and their execution times were compared.
*/

/*
TOP 10 VIVA QUESTIONS AND ONE-LINE ANSWERS:

1. What is Quick Sort?
   Quick Sort is a divide-and-conquer sorting algorithm.

2. What is a pivot?
   A pivot is an element used to divide the array into two parts.

3. What is Deterministic Quick Sort?
   It selects the pivot using a fixed rule; here, the first element.

4. What is Randomized Quick Sort?
   It selects the pivot randomly from the array.

5. What is the difference between Deterministic and Randomized Quick Sort?
   Deterministic uses a fixed pivot, while Randomized uses a random pivot.

6. What is the time complexity of Quick Sort?
   Best/Average: O(n log n), Worst: O(n^2).

7. What is the space complexity of Quick Sort?
   O(n) in the worst case due to the recursion stack.

8. Which technique does Quick Sort use?
   Divide and Conquer.

9. Why can Randomized Quick Sort perform better in some cases?
   Random pivot selection reduces the chance of consistently unbalanced partitions.

10. Which Java class generates random numbers in this code?
    The Random class.

BONUS VIVA QUESTIONS:

11. Is Quick Sort stable?
    No, Quick Sort is generally unstable.

12. Which method measures execution time in this code?
    System.nanoTime().

13. What is partitioning?
    Partitioning divides the array around the pivot.

14. When does recursion stop?
    When low >= high.

15. What is the main advantage of Quick Sort?
    It is efficient for sorting arrays on average.
*/

