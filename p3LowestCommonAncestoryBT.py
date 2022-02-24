
"""
time: O(N)
space: O(1)

"""


class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if not root:
            return
        x = self.lowestCommonAncestor(root.left,p,q)
        y = self.lowestCommonAncestor(root.right,p,q)
        if x and y:
            return root
        if root == p or root == q:
            return root
        if x or y:
            return x or y        
        return None