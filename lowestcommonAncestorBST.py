# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        #     if root.val < p.val and root.val < q.val : return self.lowestCommonAncestor(root.right,p,q)
        #     elif root.val > p.val and root.val > q.val : return self.lowestCommonAncestor(root.left,p,q)
        #     else: return root
        while True:
            if root.val < p.val and root.val < q.val:
                root = root.right
            elif root.val > p.val and root.val > q.val:
                root = root.left
            else:
                return root

# Recrusivice
# TC:- O(logn)
# Space:-O(heighttree)

# Iterative

# TC :- O(lgn)
# Space:-O(1)