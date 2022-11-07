# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        # recursive - TC - O(h)
        # SC - O(h) -- recursive stack space
        if root is None: return root

        # if root.val <  p.val and root.val < q.val:
        #     return self.lowestCommonAncestor(root.right, p, q)
        # elif root.val > p.val and root.val > q.val:
        #     return self.lowestCommonAncestor(root.left, p, q)
        # else:
        #     return root

        # iterative
        # TC = O(h)
        # SC = O(1)
        while (True):
            if root.val > p.val and root.val > q.val:
                root = root.left
            elif root.val < p.val and root.val < q.val:
                root = root.right
            else:
                return root


