/*
PRACTICAL 3: HUFFMAN ENCODING

AIM:
Implement Huffman Encoding using a Greedy Strategy.

THEORY:
Huffman Encoding is a lossless data compression technique. It assigns shorter
binary codes to characters with higher frequencies and longer binary codes
to characters with lower frequencies.

GREEDY STRATEGY:
1. Select the two nodes having the lowest frequencies.
2. Remove these two nodes from the priority queue.
3. Create a new parent node with frequency equal to their sum.
4. Make the first node the left child and the second node the right child.
5. Insert the new parent node into the priority queue.
6. Repeat until only one node remains.
7. Traverse the tree: use 0 for the left branch and 1 for the right branch.

JAVA PROGRAM:
*/

import java.util.*;

public class Huffman {

    static class Node {
        char ch;
        int freq;
        Node left, right;

        Node(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }

        Node(int freq, Node left, Node right) {
            this.freq = freq;
            this.left = left;
            this.right = right;
        }
    }

    static void printCodes(Node root, String code) {
        if (root.left == null && root.right == null) {
            System.out.println(root.ch + " : " + (code.isEmpty() ? "0" : code));
            return;
        }

        printCodes(root.left, code + "0");
        printCodes(root.right, code + "1");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of characters: ");
        int n = sc.nextInt();

        PriorityQueue<Node> pq =
            new PriorityQueue<>((a, b) -> a.freq - b.freq);

        for (int i = 0; i < n; i++) {
            System.out.print("Enter character: ");
            char ch = sc.next().charAt(0);

            System.out.print("Enter frequency: ");
            int freq = sc.nextInt();

            pq.add(new Node(ch, freq));
        }

        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();

            Node parent = new Node(left.freq + right.freq, left, right);
            pq.add(parent);
        }

        System.out.println("\nCharacter : Huffman Code");

        if (!pq.isEmpty()) {
            printCodes(pq.poll(), "");
        }

        sc.close();
    }
}

/*
SAMPLE INPUT:
Enter number of characters: 3
Enter character: A
Enter frequency: 5
Enter character: B
Enter frequency: 9
Enter character: C
Enter frequency: 12

SAMPLE OUTPUT:
Character : Huffman Code
A : 10
B : 11
C : 0

INPUT (I/P):
Enter number of characters: 3
Enter character: A
Enter frequency: 5
Enter character: B
Enter frequency: 9
Enter character: C
Enter frequency: 12

OUTPUT (O/P):
Character : Huffman Code
A : 10
B : 11
C : 0

ALGORITHM:
1. Start.
2. Read the number of characters.
3. Read each character and its frequency.
4. Insert every character as a node into a min-priority queue.
5. While the queue contains more than one node:
   a. Remove the two nodes with the smallest frequencies.
   b. Create a parent node with the sum of their frequencies.
   c. Set the removed nodes as its left and right children.
   d. Insert the parent node into the queue.
6. The remaining node is the root of the Huffman tree.
7. Traverse the tree and print 0 for a left edge and 1 for a right edge.
8. Stop.

TIME COMPLEXITY:
O(n log n), where n is the number of characters.

SPACE COMPLEXITY:
O(n), for the priority queue and Huffman tree.

RESULT:
Thus, Huffman Encoding using the Greedy Strategy was implemented successfully.

VIVA QUESTIONS AND ANSWERS:

1. What is Huffman Encoding?
Huffman Encoding is a lossless data compression technique that assigns
variable-length binary codes to characters based on their frequencies.

2. Which strategy is used in Huffman Encoding?
Greedy Strategy.

3. Which data structure is used?
Min Priority Queue (Min Heap).

4. Why is it called a greedy algorithm?
Because it repeatedly selects the two nodes with the smallest frequencies.

5. What does 0 represent?
The left branch of the Huffman tree.

6. What does 1 represent?
The right branch of the Huffman tree.

7. What is the time complexity?
O(n log n).

8. What is the space complexity?
O(n).

9. Is Huffman Encoding lossless or lossy?
It is lossless compression.

10. Where is Huffman Encoding used?
It is used in data compression formats and applications such as ZIP and some
image compression techniques.

NOTE:
If multiple characters have equal frequencies, more than one valid Huffman
code arrangement may be possible. The exact codes can differ while still
being valid and having the same total encoded cost.
*/
