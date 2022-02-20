#Time Complexity O(N)
#Space Complexity O(1)

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        parent_value = root.val
        
        p_value = p.val
        q_value = q.val
        
        if p_value >parent_value and q_value > parent_value:
            return self.lowestCommonAncestor(root.right,p,q)
        
        elif p_value < parent_value and q_value < parent_value:
            return self.lowestCommonAncestor(root.left,p,q)
        
        else:
            return root
            
        
        
