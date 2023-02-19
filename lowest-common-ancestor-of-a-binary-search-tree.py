"""
Recursive Solution:
TC: O(h)
SC: O(h)
"""
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if not root: return None
        if p.val > q.val:  return self.lowestCommonAncestor(root, q, p)

        if root.val < p.val: return self.lowestCommonAncestor(root.right, p, q)
        elif root.val > q.val: return self.lowestCommonAncestor(root.left, p, q)
        else: return root

"""
Iterative Solution:
TC: O(h)
SC: O(1)
"""
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if p.val > q.val: return self.lowestCommonAncestor(root, q, p)
        while root:
            if root.val < p.val: root = root.right
            elif root.val > q.val: root = root.left
            else: return root
        return None