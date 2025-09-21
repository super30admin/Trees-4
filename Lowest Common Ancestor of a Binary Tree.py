#  Time Complexity : O(n)
#  Space Complexity : O(h)
#  Did this code successfully run on Leetcode : Yes
#  Three line explanation of solution in plain english : This code finds the Lowest Common Ancestor (LCA) of two nodes in a binary tree by recording the paths from the root to both p and q. The helper function recursively traverses the tree, building a path, and when it reaches p or q, it stores the corresponding path in self.pathP or self.pathQ. Finally, the main function compares both paths node by node and returns the last common node before they diverge.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def __init__(self):
        self.pathP = None
        self.pathQ = None

    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        self.helper(root, p, q, [])

        for i in range(len(self.pathP)):
            if self.pathP[i] != self.pathQ[i]:
                return self.pathP[i - 1]
        
        return None
    def helper(self, root, p, q, path):
        if root is None:
            return 
        
        path.append(root)

        if p == root:
            self.pathP = list(path)
            self.pathP.append(root)
        
        if q == root:
            self.pathQ = list(path)
            self.pathQ.append(root)
        
        if self.pathP is None or self.pathQ is None:
            self.helper(root.left, p, q, path)
        
        if self.pathP is None or self.pathQ is None:
            self.helper(root.right, p, q, path)
        
        path.pop()
