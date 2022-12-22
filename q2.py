# Time Complexity : O(h), Where h is height of the Binary search Tree
# Space Complexity : O(h), Where h is height of the Binary search Tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nothing specific

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        #Edge Case
        if(root==None):
            return None
        
        #Actual Logic
        if(root.val>p.val and root.val>q.val):
            #Move towards the left, We get solution from the left subtree
            return self.lowestCommonAncestor(root.left,p,q)
        if(root.val<p.val and root.val<q.val):
            #Move towards the right, We get solution from the right subtree
            return self.lowestCommonAncestor(root.right,p,q)
        else:
            return root
        