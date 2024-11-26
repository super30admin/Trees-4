# Time complexity - O(h) => O(logn)
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root:
            if p.val < root.val and q.val < root.val:
                return self.lowestCommonAncestor(root.left,p,q)
            elif p.val > root.val and q.val > root.val:
                return self.lowestCommonAncestor(root.right,p,q)
            else:
                return root


class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        while root:
            if p.val < root.val and q.val < root.val:
                root = root.left
            elif p.val > root.val and q.val > root.val:
                root = root.right
            else:
                return root
