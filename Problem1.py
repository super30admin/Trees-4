"""
TC: O(H + k) {We traverse nodes following in-order order (left → root → right).  
              In the worst case, we may traverse down the tree height H and then
              visit k nodes until the k-th smallest is found.}
SC: O(H) {Recursive call stack depends on the height of the BST.  
          For a balanced tree, H ≈ logN; for a skewed tree, H ≈ N.}

Approach:
We are asked to find the k-th smallest value in a Binary Search Tree (BST).  
A BST’s key structural property—that in-order traversal visits nodes in ascending order—
makes this efficient.

Key idea:
Perform an in-order traversal (Left → Node → Right) and decrement `k` as nodes are visited.  
The moment `k` becomes zero, we have arrived at the k-th smallest node.

Steps:
1. Use a recursive DFS helper to perform in-order traversal.
2. Traverse to the left subtree first, as smaller values reside there.
3. After returning from left, decrement `k` to represent visiting the next smallest element.
4. When `k == 0`, record the current node’s value as the result.
5. Traverse the right subtree only if necessary.
6. Use a closure variable (`nonlocal k`) to keep track of remaining nodes without 
   maintaining a global list.

This in-order traversal ensures we visit nodes in sorted order and stop early 
as soon as the answer is found.

This problem ran successfully on Leetcode.
"""


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        
        def dfs(node):
            nonlocal res, k
            #logic
            if node.left:
                dfs(node.left)

            k -= 1

            if k == 0:
                res = node.val
                return

            if node.right:
                dfs(node.right)

                    
        res = None
        dfs(root)
        return res