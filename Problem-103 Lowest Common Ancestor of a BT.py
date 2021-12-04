# 236. Lowest Common Ancestor of a Binary Tree
# https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

# Logic: 
# Brute Force: Find path from root to p and q. Iterate over both the paths and find the last common node.

# Efficient: We recurse on both the sides of the node, if the node is none, 
# we return none, and if the node is equal to either p or q, we return node. 
# At the moment when both left and right have a node, we know that the current 
# node is the LCA.

# Time Complexity: O(h)
# Space Complexity: O(h)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if not root:
            return
        
        if root.val in [p.val, q.val]:
            return root
        
        l = self.lowestCommonAncestor(root.left, p, q)
        r = self.lowestCommonAncestor(root.right, p, q)
        
        if l and r:
            return root
        elif l:
            return l
        else:
            return r