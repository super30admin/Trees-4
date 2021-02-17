# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        # TC - O(N) not log N because what if skewed tree is given
        # SC - O(1) if iterative is implemented O(N) for recursive stack (implicit or explicit)
        
        #base case
        if root == None:
            return 0
        
        pval = p.val
        qval = q.val
        
        node = root
        
        while(node):
            
            value = node.val
            
            #both nodes on left side
            if(pval<value and qval<value):
                node=node.left
            
            # both nodes on right side
            elif (pval>value and qval>value):
                node = node.right
             
            # node is the solution
            else:
                return node
            
        return None
    
        '''
        #TC - O(N)
        #SC - O(N) recursive stack
        # recursive solution
        
        val = root.val
        
        pval = p.val
        qval = q.val
        
        if (pval>val and qval>val):
            return lowestCommonAncestor(root.right,p,q)
            
        elif (pval<val and qval<val):
            return lowestCommonAncestor(root.left,p,q)
            
        else:
            return root
        
        '''