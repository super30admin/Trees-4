"""
TC: O(H) {At each step we navigate either left or right in the BST based on value comparisons.  
          The search depth corresponds to the tree height H (logN for balanced, N for skewed).}
SC: O(H) {Recursive calls follow the root-to-leaf path.  
          For a balanced BST this is O(logN); for a skewed tree, O(N).}

Approach:
We must find the Lowest Common Ancestor (LCA) of two nodes in a Binary Search Tree (BST).  
The BST’s ordering property allows us to avoid exploring the entire tree and instead  
navigate using value comparisons.

Key idea:
For nodes p and q, their LCA is the first node whose value lies between p.val and q.val.  
If both target nodes lie on the same side of the current root:
    - both < root.val → move left
    - both > root.val → move right
Otherwise, the current root is the split point and thus the LCA.

Steps:
1. Compare root.val with p.val and q.val.
2. If root lies between the two values (inclusive), it is the LCA.
3. If both values are smaller than root.val: recurse into the left subtree.
4. If both values are greater than root.val: recurse into the right subtree.
5. Recursion naturally ends when the split point is found.

This approach leverages the BST structure to locate the LCA without scanning the entire tree.

This problem ran successfully on Leetcode.
"""


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if min(q.val, p.val) <= root.val <= max(q.val, p.val):
            return root
        elif root.val > max(p.val, q.val) :
            #go left
            return self.lowestCommonAncestor(root.left, p, q)
        else:
            #go right
            return self.lowestCommonAncestor(root.right, p, q)