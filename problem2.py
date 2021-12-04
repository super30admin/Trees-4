#Time and space O(n)
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        if root.val > p.val and root.val > q.val:
            return self.lowestCommonAncestor(root.left,p,q)
        
        elif root.val < p.val and root.val < q.val:
            return self.lowestCommonAncestor(root.right,p,q)
        
        else:
            return root
