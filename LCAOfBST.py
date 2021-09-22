"""
Time Complexity : O(n) where n is the number of nodes 
Space Complexity : O(1) in case of iterative method and 0(n) in recursive
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
        if not root:
            return root
        """# Check if the root node is greater than p and q we move towards left
        if root.val > p.val and root.val > q.val:
            return self.lowestCommonAncestor(root.left, p, q)
        # Check if the root node if less than p and q we move towards right
        elif root.val < p.val and root.val < q.val:
            return self.lowestCommonAncestor(root.right, p, q)
        # If the root node is either equal to p or q we simply return the node
        else:
            return root"""
        while True:
            # Check if the root node is greater than p and q we move towards left
            if root.val > p.val and root.val > q.val:
                root = root.left
            # Check if the root node if less than p and q we move towards right
            elif root.val < p.val and root.val < q.val:
                root = root.right
            # If the root node is either equal to p or q we simply return the node
            else:
                return root