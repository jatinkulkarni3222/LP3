import java.util.Scanner;

public class NQueen {

    // Check whether a queen can be placed safely
    static boolean isSafe(int[][] board, int row, int col, int n) {
        // Check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1)
                return false;
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1)
                return false;
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 1)
                return false;
        }

        return true;
    }

    // Place queens using backtracking
    static boolean solve(int[][] board, int row, int n) {
        if (row == n)
            return true;

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 1;

                if (solve(board, row + 1, n))
                    return true;

                board[row][col] = 0; // Backtrack
            }
        }

        return false;
    }

    // Print the board
    static void printBoard(int[][] board, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the value of N: ");
        int n = sc.nextInt();

        int[][] board = new int[n][n];

        if (solve(board, 0, n)) {
            System.out.println("Solution for " + n + " Queens:");
            printBoard(board, n);
        } else {
            System.out.println("No solution exists");
        }

        sc.close();
    }
}

// Enter the value of N: 4
// Solution for 4 Queens:
// 0 1 0 0
// 0 0 0 1
// 1 0 0 0
// 0 0 1 0
//
// Enter the value of N: 2
// No solution exists
//
// Time Complexity: O(N!)
// Space Complexity: O(N²)



// VIVA QUESTIONS AND ANSWERS

// Q1. What is the N-Queen problem?
// Ans: Place N queens on an N×N chessboard so that no two queens attack each other.

// Q2. Which technique is used in this program?
// Ans: Backtracking.

// Q3. What is backtracking?
// Ans: It tries a solution and reverses the choice if it leads to failure.

// Q4. What does isSafe() check?
// Ans: It checks the column and both upper diagonals for another queen.

// Q5. Why do we place one queen per row?
// Ans: To ensure that no two queens share the same row.

// Q6. What is the base condition in solve()?
// Ans: If row == n, all queens are placed successfully.

// Q7. Why is board[row][col] reset to 0?
// Ans: To undo a placement when it does not lead to a solution.

// Q8. What does the value 1 represent on the board?
// Ans: A queen is placed in that cell.

// Q9. What is the time complexity?
// Ans: Approximately O(N!) in the standard backtracking analysis.

// Q10. What is the space complexity?
// Ans: O(N²) for the board, excluding recursion stack space.
