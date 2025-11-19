"""
TC: O(N) {In the worst case, we visit every node of the tree once, where N is the total number of nodes.  
          Each node is processed in constant time.}
SC: O(H) {The recursion stack can go as deep as the height H of the tree.  
          For a balanced tree, H ≈ logN; for a skewed tree, H ≈ N.}

Approach:
We are tasked with finding the Lowest Common Ancestor (LCA) of two nodes in a binary tree 
(not necessarily a BST).  

Key idea:
Using recursion, we explore both left and right subtrees of each node:
    - If the current node matches either p or q, it could be part of the LCA path.
    - Recursively search left and right subtrees for p and q.
    - If both subtrees return non-null values, the current node is the LCA.
    - If only one subtree returns a non-null value, propagate that upwards.

Steps:
1. Base case: if the current node is null or matches p or q, return it.
2. Recursively find p and q in the left subtree.
3. Recursively find p and q in the right subtree.
4. If both left and right calls return non-null, the current node is their LCA.
5. Otherwise, return the non-null result (if any) from left or right.

This bottom-up approach ensures that the first node where p and q diverge in the recursion 
tree is returned as the LCA.

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
        
        if not root or root.val == p.val or root.val == q.val:
            return root
        
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)

        if left and right:
            return root
        elif not left:
            return right
        else:
            return left