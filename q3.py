# Time Complexity : O(n), Where n is number of elments in the Binary Tree
# Space Complexity : O(h), Where h is height of the Binary Tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nothing specific

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    #This is post order traversal approach
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        #Base Case
        if(root==None or root==p or root==q):
            return root
        #Actual Logic
        l=self.lowestCommonAncestor(root.left,p,q)
        r=self.lowestCommonAncestor(root.right,p,q)
        if(l==None and r==None):
            return None
        if(l==None and r!=None):
            return r
        if(l!=None and r==None):
            return l
        else:
            #Here it is place where they differed for first time
            return root
        