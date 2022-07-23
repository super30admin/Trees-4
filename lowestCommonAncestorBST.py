# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
# TC:O(logn(N)

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        # if p.val < root.val and q.val < root.val :
        #     return self.lowestCommonAncestor(root.left, p,q)
        # if p.val > root.val and q.val > root.val :
        #     return self.lowestCommonAncestor(root.right, p,q)
        # else:
        #     return root
        node = root
        while True:
            if p.val < node.val and q.val < node.val :
                node = node.left
            elif p.val > node.val and q.val > node.val :
                node = node.right
            else:
                return node
