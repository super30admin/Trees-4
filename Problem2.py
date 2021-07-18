# Time Complexity : O(logn)
# Space Complexity : O(logn)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# in bst values greater than root will be on right side and lesser values will be on right side
# if values are on either side then root is lowest common ancestor
# if one of the values of p or q equals root.val then root is lowestCommonAncestor

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root == None or p == None or q == None:
            return root
        
        if p == q:
            return p
        
        if p.val > q.val:
            return self.lowestCommonAncestor(root,q,p)
        
        if p.val == root.val:
            return p
        if q.val == root.val:
            return q
        
        if p.val < root.val and q.val < root.val:
            return self.lowestCommonAncestor(root.left,q,p)
        
        if p.val > root.val and q.val > root.val:
            return self.lowestCommonAncestor(root.right,q,p)
        
        return root
        
            
        