# TC: O(h)
# SC: O(1)
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        while True:
            if (root.val>p.val and root.val<q.val) or (root.val>q.val and root.val<p.val) or (root.val==p.val or root.val==q.val):
                return root
            
            if root.val>p.val and root.val>q.val:
                root=root.left
            
            if root.val<p.val and root.val<q.val:
                root=root.right
        