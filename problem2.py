#LCA of BST
#TC: O(H) h is the height 
#SC: O(1)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        p_val = p.val
        q_val = q.val
        node = root
        while node:
            current = node.val
            if p_val > current and q_val> current:
                node = node.right
            elif p_val<current and q_val<current:
                node = node.left 
                
            else:
                return node