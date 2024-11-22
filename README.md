# Trees-4

## Problem1 Kth Smallest Element in a BST (https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/)

This solution finds the k-th smallest element in a Binary Search Tree (BST) using an in-order traversal approach. In-order traversal visits nodes in ascending order for a BST. The kthSmallest method initializes an empty list result to store the elements of the BST in sorted order. The helper method performs a recursive traversal: it first explores the left subtree (smallest elements), then adds the current node's value to result, and finally explores the right subtree (larger elements). After the traversal, the k-th smallest element (index k - 1) is retrieved from the sorted list.



## Problem2 Lowest Common Ancestor of a Binary Search Tree (https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/)

This solution efficiently finds the Lowest Common Ancestor (LCA) in a Binary Search Tree (BST) using the properties of BSTs. Starting from the root, the algorithm checks if either of the nodes p or q matches the root. If so, the root itself is the LCA. If both p and q have values less than the root’s value, the algorithm recursively searches in the left subtree. Conversely, if both values are greater than the root’s value, the search continues in the right subtree. If the values diverge (one is smaller and the other is larger), the current root is the LCA because it lies between the two nodes in the BST.



## Problem3 Lowest Common Ancestor of a Binary Tree (https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/)

The given solution is a recursive method to find the lowest common ancestor (LCA) of two nodes p and q in a binary tree. Starting from the root, the algorithm checks if the root is null or matches p or q; if so, it returns the root as a base case. It then recursively searches for p and q in the left and right subtrees. After exploring both subtrees, if both p and q are found in different subtrees (i.e., both left and right are non-null), the current root is the LCA. If only one subtree contains p or q, that subtree's result is returned. If neither subtree contains p or q, the method returns null. The recursion unwinds, propagating the LCA up the call stack.


