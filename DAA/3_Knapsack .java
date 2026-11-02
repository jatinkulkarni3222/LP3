// Aim: Solve the 0/1 Knapsack problem using dynamic programming.
// Instructions:
// 1. Enter the number of items.
// 2. Enter the weight and profit of each item.
// 3. Enter the knapsack capacity.
// 4. The program calculates maximum profit.

import java.util.Scanner;

public class Knapsack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] weight = new int[n];
        int[] profit = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight: ");
            weight[i] = sc.nextInt();

            System.out.print("Enter profit: ");
            profit[i] = sc.nextInt();
        }

        System.out.print("Enter knapsack capacity: ");
        int capacity = sc.nextInt();

        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (weight[i - 1] <= w) {
                    dp[i][w] = Math.max(
                        profit[i - 1] + dp[i - 1][w - weight[i - 1]],
                        dp[i - 1][w]
                    );
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        System.out.println("Maximum profit: " + dp[n][capacity]);
        sc.close();
    }
}

// Time Complexity: O(n * capacity)
// Space Complexity: O(n * capacity)

// Sample Input:
// Items: (5,20), (2,30), (4,15),(3,10)
// Capacity: 7
//
// I/P:
// Enter number of items: 4
// Enter weight: 5
// Enter profit: 20
// Enter weight: 2
// Enter profit: 30
// Enter weight: 4
// Enter profit: 15
// Enter weight: 3
// Enter profit: 10
// Enter knapsack capacity: 7
//
// O/P:
// Maximum profit: 50
//
// Result: Maximum profit obtained using dynamic programming.


 // VIVA QUESTIONS AND ANSWERS

// Q1. What is the 0/1 Knapsack problem?
// Ans: It is a problem of selecting items to maximize profit within a given capacity.

// Q2. Why is it called 0/1 Knapsack?
// Ans: Each item is either selected once (1) or not selected (0).

// Q3. Which technique is used in this program?
// Ans: Dynamic programming.

// Q4. What does dp[i][w] represent?
// Ans: The maximum profit using the first i items with capacity w.

// Q5. What is the base condition?
// Ans: dp[0][w] = 0 and dp[i][0] = 0.

// Q6. Why do we use Math.max()?
// Ans: To choose the maximum profit between including and excluding an item.

// Q7. When can an item be included?
// Ans: When its weight is less than or equal to the current capacity.

// Q8. What is the time complexity?
// Ans: O(n * capacity).

// Q9. What is the space complexity?
// Ans: O(n * capacity), because a 2D DP table is used.

// Q10. Where is the final maximum profit stored?
// Ans: In dp[n][capacity].

