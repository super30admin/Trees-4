# Time Complexity : O(log n) where n is number of elements in tree
# Space Complexity :O(1)
# Did this code successfully run on Leetcode :Yes
# Any problem you faced while coding this : No



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':

        # if p and q are in left subtree
        if root.val > p.val and root.val > q.val:
            return self.lowestCommonAncestor(root.left, p, q)
        # if p and q are in right subtree
        elif root.val < p.val and root.val < q.val:
            return self.lowestCommonAncestor(root.right, p, q)
        else:
            # if p and q are in different subtree
            return root




