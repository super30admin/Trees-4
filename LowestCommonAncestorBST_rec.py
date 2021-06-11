# TC: O(logN) in average case, since we would be skipping half side of tree if p and q are greater or lesser than the root and O(N) in worst case. 
# SC: O(logN) where logN would be the size of the recuresive stack. 

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        if p.val < root.val and q.val < root.val: 
            return self.lowestCommonAncestor(root.left, p, q)
            
        elif p.val > root.val and q.val > root.val: 
            return self.lowestCommonAncestor(root.right, p, q)
        
        else: 
            return root
