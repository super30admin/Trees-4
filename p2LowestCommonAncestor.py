
"""
time: O(N)
space: O(1)

"""

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':

        while root:
            if p.val < root.val and p.val < root.val:
                root = root.left
            elif p.val > root.val and q.val > root.val:
                root = root.right
            else: return root
        return None