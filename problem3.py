#Time space O(n)
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        if root is None:
            return None
        #If we found the value 
        if root.val== p.val or root.val == q.val:
            return root
      #Traverse left and right   
        l= self.lowestCommonAncestor(root.left,p,q)
        r=self.lowestCommonAncestor(root.right,p,q)
    
    #If one is on left and other is on right
        if l and r:
            return root
    #If both are on left
        elif l:
            return l
    #If both are on right
        else:
            return r
        
