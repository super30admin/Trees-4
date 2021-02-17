# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
# Time: O(log n)
# Space: O(n) because height = n for skewed bst 
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        # logic
        if(root.val < p.val and root.val < q.val):
            return self.lowestCommonAncestor(root.right, p , q)
        elif(root.val > p.val and root.val > q.val):
            return self.lowestCommonAncestor(root.left, p , q)
        else:
            return root
        