# TC:O(N)
# SC:O(1)
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root ==None or root.val==p.val or root.val==q.val:
            return root
        
        left=self.lowestCommonAncestor(root.left,p,q)
        right=self.lowestCommonAncestor(root.right,p,q)
        
        if left!=None and right!=None:
            return root
        elif left!=None:
            return left
        else:
            return right