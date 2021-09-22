"""
Time Complexity : O(n) where n is the number of nodes 
Space Complexity : O(h) where h is the height of the tree
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        self.path1 = []
        self.path2 = []
        if not root:
            return root
        self.backtrack(root, p, q, [])
        # We find the element where mismatch occurs and the element before the
        # mismatch would be our LCA
        for i in range(len(self.path1)):
            if self.path1[i] != self.path2[i]:
                return self.path1[i - 1]
    def backtrack(self, root, p, q, path):
        # Base
        if not root:
            return
        # If the node is found we copy over the path list to path1 and append the 
        # current node twice for both p and q
        if root == p:
            self.path1 = path.copy()
            self.path1.append(p)
            self.path1.append(p)
        if root == q:
            self.path2 = path.copy()
            self.path2.append(q)
            self.path2.append(q)
        # Logic
        # Action
        path.append(root)
        # Recurse
        self.backtrack(root.left, p, q, path)
        if len(self.path1) == 0 or len(self.path2) == 0:
            self.backtrack(root.right, p , q, path)
        # Backtrack
        path.remove(root)