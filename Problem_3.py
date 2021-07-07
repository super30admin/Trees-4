# Runs on Leetcode

    # Runtime - O(n)
    # Memory - O()
    
    
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode'):
        if not root:
            return None
        
        if root == p or root == q:
            return root
        
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p ,q)
        
        if left and right:
            return root
        
        elif not left and right:
            return right
        
        elif left and not right:
            return left
        
        else:
            return None
