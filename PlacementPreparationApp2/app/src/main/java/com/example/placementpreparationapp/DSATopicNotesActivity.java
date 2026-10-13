package com.example.placementpreparationapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DSATopicNotesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dsa_topic_notes);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView topicTitle = findViewById(R.id.topicTitle);
        TextView topicContent = findViewById(R.id.topicContent);

        String topic = getIntent().getStringExtra("topic");
        if (topic == null) {
            topic = "DSA";
        }

        topicTitle.setText(topic);

        if (topic.equals("Arrays")) {
            topicContent.setText(
                    "What is an Array?\n\n" +
                            "An array is a data structure used to store multiple elements of the same type in contiguous memory locations.\n\n" +
                            "Example:\nint[] arr = {10, 20, 30, 40, 50};\n\n" +
                            "Important Operations:\n\n" +
                            "1. Traversal\nVisit every element of the array.\n\n" +
                            "2. Searching\nFind whether a particular element exists.\n\n" +
                            "3. Insertion\nAdd a new element at a specific position.\n\n" +
                            "4. Deletion\nRemove an element from the array.\n\n" +
                            "5. Sorting\nArrange elements in ascending or descending order.\n\n" +
                            "Time Complexity:\n\n" +
                            "Access: O(1)\nSearch: O(n)\nInsertion: O(n)\nDeletion: O(n)\n\n" +
                            "Important Interview Topics:\n" +
                            "• Two Pointer Technique\n• Sliding Window\n• Prefix Sum\n• Kadane's Algorithm\n• Binary Search"
            );
        } else if (topic.equals("Strings")) {
            topicContent.setText(
                    "What is a String?\n\n" +
                            "A String is a sequence of characters.\n\n" +
                            "Example:\nString name = \"Archanaa\";\n\n" +
                            "Important Concepts:\n\n" +
                            "1. String Traversal\nVisit each character in the string.\n\n" +
                            "2. String Comparison\nCompare two strings using equals().\n\n" +
                            "3. String Reversal\nReverse the characters of a string.\n\n" +
                            "4. Palindrome\nCheck whether a string reads the same forward and backward.\n\n" +
                            "5. Anagram\nCheck whether two strings contain the same characters.\n\n" +
                            "Important Interview Topics:\n\n" +
                            "• Palindrome\n• Anagram\n• Frequency Counting\n• Character Hashing\n• StringBuilder"
            );
        } else if (topic.equals("Linked List")) {
            topicContent.setText(
                    "What is a Linked List?\n\n" +
                            "A Linked List is a linear data structure where each node contains data and a reference to the next node.\n\n" +
                            "Types:\n\n" +
                            "1. Singly Linked List\nEach node points to the next node.\n\n" +
                            "2. Doubly Linked List\nEach node points to both previous and next nodes.\n\n" +
                            "3. Circular Linked List\nThe last node points back to the first node.\n\n" +
                            "Important Operations:\n\n" +
                            "• Insertion\n• Deletion\n• Traversal\n• Searching\n• Reversal\n\n" +
                            "Important Interview Problems:\n\n" +
                            "• Reverse a Linked List\n• Find Middle Node\n• Detect Cycle\n• Merge Two Sorted Lists"
            );
        } else if (topic.equals("Stack")) {
            topicContent.setText(
                    "What is a Stack?\n\n" +
                            "A Stack is a linear data structure that follows the LIFO principle.\n\n" +
                            "LIFO means Last In First Out.\n\n" +
                            "Main Operations:\n\n" +
                            "1. Push\nAdd an element.\n\n" +
                            "2. Pop\nRemove the top element.\n\n" +
                            "3. Peek\nView the top element.\n\n" +
                            "Applications:\n\n" +
                            "• Function Calls\n• Undo Operations\n• Browser History\n• Parentheses Matching\n• Expression Evaluation"
            );
        } else if (topic.equals("Queue")) {
            topicContent.setText(
                    "What is a Queue?\n\n" +
                            "A Queue is a linear data structure that follows the FIFO principle.\n\n" +
                            "FIFO means First In First Out.\n\n" +
                            "Main Operations:\n\n" +
                            "1. Enqueue\nAdd an element to the rear.\n\n" +
                            "2. Dequeue\nRemove an element from the front.\n\n" +
                            "3. Peek\nView the front element.\n\n" +
                            "Applications:\n\n" +
                            "• CPU Scheduling\n• Printer Queue\n• BFS Traversal\n• Task Scheduling"
            );
        } else if (topic.equals("Hashing")) {
            topicContent.setText(
                    "What is Hashing?\n\n" +
                            "Hashing is a technique used to store and retrieve data efficiently using a hash function.\n\n" +
                            "Java provides:\n\n" +
                            "• HashMap\n• HashSet\n• Hashtable\n\n" +
                            "Important Applications:\n\n" +
                            "• Frequency Counting\n• Finding Duplicates\n• Two Sum Problem\n• Checking Unique Elements\n• Fast Lookup"
            );
        } else if (topic.equals("Recursion")) {
            topicContent.setText(
                    "What is Recursion?\n\n" +
                            "Recursion is a technique where a function calls itself to solve a smaller version of the same problem.\n\n" +
                            "Every recursive solution should have:\n\n" +
                            "1. Base Case\nStops the recursion.\n\n" +
                            "2. Recursive Case\nCalls the function again.\n\n" +
                            "Common Problems:\n\n" +
                            "• Factorial\n• Fibonacci\n• Tower of Hanoi\n• Tree Traversal\n• Backtracking"
            );
        } else if (topic.equals("Binary Search")) {
            topicContent.setText(
                    "What is Binary Search?\n\n" +
                            "Binary Search is an efficient searching algorithm used on sorted data.\n\n" +
                            "Approach:\n\n" +
                            "1. Find the middle element.\n2. Compare it with the target.\n3. Eliminate half of the search space.\n4. Repeat until the element is found.\n\n" +
                            "Time Complexity:\nO(log n)\n\n" +
                            "Important Problems:\n\n" +
                            "• Search in Sorted Array\n• First and Last Position\n• Search in Rotated Sorted Array\n• Square Root using Binary Search"
            );
        } else if (topic.equals("Trees")) {
            topicContent.setText(
                    "What is a Tree?\n\n" +
                            "A Tree is a non-linear hierarchical data structure consisting of nodes connected by edges.\n\n" +
                            "Important Types:\n\n" +
                            "• Binary Tree\n• Binary Search Tree\n• AVL Tree\n• Heap\n\n" +
                            "Tree Traversals:\n\n" +
                            "1. Inorder\n2. Preorder\n3. Postorder\n4. Level Order\n\n" +
                            "Important Problems:\n\n" +
                            "• Maximum Depth\n• Level Order Traversal\n• Validate BST\n• Lowest Common Ancestor"
            );
        } else if (topic.equals("Graphs")) {
            topicContent.setText(
                    "What is a Graph?\n\n" +
                            "A Graph is a non-linear data structure consisting of vertices and edges.\n\n" +
                            "Types:\n\n" +
                            "• Directed Graph\n• Undirected Graph\n• Weighted Graph\n• Unweighted Graph\n\n" +
                            "Important Algorithms:\n\n" +
                            "• BFS\n• DFS\n• Dijkstra Algorithm\n• Prim's Algorithm\n• Kruskal's Algorithm\n\n" +
                            "Important Problems:\n\n" +
                            "• Shortest Path\n• Cycle Detection\n• Connected Components"
            );
        } else if (topic.equals("Dynamic Programming")) {
            topicContent.setText(
                    "What is Dynamic Programming?\n\n" +
                            "Dynamic Programming is an optimization technique used to solve problems by storing results of previously solved subproblems.\n\n" +
                            "Two Main Approaches:\n\n" +
                            "1. Memoization\nTop-down approach using recursion and caching.\n\n" +
                            "2. Tabulation\nBottom-up approach using iterative tables.\n\n" +
                            "Important Problems:\n\n" +
                            "• Fibonacci\n• 0/1 Knapsack\n• Longest Common Subsequence\n• Longest Increasing Subsequence\n• Coin Change"
            );
        }
    }
}
