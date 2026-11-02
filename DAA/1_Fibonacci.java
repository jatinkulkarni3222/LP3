// PRACTICAL 1: FIBONACCI SERIES

// Aim: Write a non-recursive and recursive program to
// calculate Fibonacci numbers and analyze their time
// and space complexity.

import java.util.Scanner;

class Main {

    // Non-recursive Fibonacci series
    static void fibonacci(int n) {
        int a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            int temp = a + b;
            a = b;
            b = temp;
        }
    }

    // Recursive Fibonacci number
    static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of terms: ");
        int n = sc.nextInt();

        System.out.println("Non-recursive:");
        fibonacci(n);

        System.out.println("\nRecursive:");
        for (int i = 0; i < n; i++) {
            System.out.print(fib(i) + " ");
        }

        sc.close();
    }
}

// Non-Recursive: Time – O(n), Space – O(1)
// Recursive: Time – O(2ⁿ), Space – O(n).

// Sample Input:
// 5
//
// Sample Output:
// Enter number of terms: 5
// Non-recursive:
// 0 1 1 2 3
// Recursive:
// 0 1 1 2 3




// VIVA QUESTIONS AND ANSWERS

// Q1. What is the Fibonacci series?
// Ans: A series where each number is the sum of the previous two numbers.

// Q2. What is recursion?
// Ans: Recursion is a process in which a function calls itself.

// Q3. What is iteration?
// Ans: Iteration means repeating statements using loops.

// Q4. What is the base condition in recursion?
// Ans: The condition that stops recursive function calls.

// Q5. What is the time complexity of the non-recursive method?
// Ans: O(n).

// Q6. What is the time complexity of the recursive method?
// Ans: O(2^n) as an upper-bound estimate for naive recursion.

// Q7. What is the space complexity of the non-recursive method?
// Ans: O(1).

// Q8. What is the space complexity of the recursive method?
// Ans: O(n), due to the recursion call stack.

// Q9. Why is recursion slower than iteration here?
// Ans: It repeats calculations and makes many function calls.

// Q10. Which method is better and why?
// Ans: The iterative method is generally better because it takes O(n) time and O(1) space.