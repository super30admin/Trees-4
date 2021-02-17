# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        if root == None:
            return root
        
        self.result=None # For storing the LCA node
        
        self.helper(root,p,q) # Traversing through the tree
        return self.result
    
    def helper(self,root,p,q):
        
        # If reached the end of a branch, return False.
        if root == None:
            return False
        
        # Left Recursion
        left = self.helper(root.left,p,q)
        
        # Right Recursion
        right = self.helper(root.right,p,q)
        
        # If the current node is one of p or q
        mid = root.val == p.val or root.val == q.val
         
        # If any two of the three flags left, right or mid become True.
        if left+right+mid>=2:
            self.result= root
        
        # Return True if either of the three bool values is True.
        return left or right or mid
            
        
        
        