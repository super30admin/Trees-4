# Time complexity : O(n)
# Space complexity : O(1)
# Leetcode : Solved and submitted

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        # check for root if null
        if not root:
            return None
        
        # we continue until we reach the else part
        while True:
          # if both values are lesser, move to left sub-tree
            if root.val > p.val and root.val > q.val:
                root = root.left
          # if both values are greater, move to right sub-tree
            elif root.val < p.val and root.val < q.val:
                root = root.right
            else:
              # else root is the LCA
                return root
