"""
// Time Complexity : o(n)
// Space Complexity : o(h), recursive stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        #base
        if not root:#when value is not found in that branch
            return
        
        if root.val == p.val or root.val == q.val:
            return root #when either value is found, return it
        
        #logic
        left = self.lowestCommonAncestor(root.left,p,q)
        right = self.lowestCommonAncestor(root.right,p,q) 
        
        
        if left and right: #when right and left are not null, return the root, that will be the answer
            return root
        
        if left: #if the second number wasnt found in the right subtree, just return left
            return left 
        
        if right: # similarly for right
            return right