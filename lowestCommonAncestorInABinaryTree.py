# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        def helper(root):
            if not root:
                return None
            l = helper(root.left)
            r = helper(root.right)
            
            if l and r:
                return root
            #below if is optional as the next if also takes care of this
            # if (root.val == p.val or root.val == q.val) and (l or r):
            #     return root
            if root.val == p.val or root.val == q.val:
                return root
            return l or r
        return helper(root)