# Time complexity : O(h)
# Space complexity : O(h)
# Leetcode : Solved and submitted

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        # if root is null, then return None
        if not root:
            return None
        
        # In BST, if both values are lesser than root, it will surely be in the left sub-tree, so calling recurively to the left
        if root.val > p.val and root.val > q.val:
            return self.lowestCommonAncestor(root.left, p, q)
        # In BST, if both values are greater than root, it will surely be in the right sub-tree, so calling recurively to the right
        elif root.val < p.val and root.val < q.val:
            return self.lowestCommonAncestor(root.right, p, q)
        else:
          # else we return the root which is the Least Common Ancestor
            return root
