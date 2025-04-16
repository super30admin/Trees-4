'''
    Time Complexity: O(logn)
    Space Complexity: O(logn)
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        return self.helper(root, p , q)

    def helper(self, root, p, q):
        # base case
        if (p.val <= root.val <= q.val) or (q.val <= root.val <= p.val):
            return root

        # logic
        if p.val < root.val and q.val < root.val:
            return self.helper(root.left, p, q)
        
        if p.val > root.val and q.val > root.val:
            return self.helper(root.right, p, q)