# // Time Complexity : O(n)
# // Space Complexity : (h)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this : Nope


# // Your code here along with comments explaining your approach


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        #If no root then return
        if not root:
            return None
        
        #If any of the node is equal to root return the root
        if p==root or q==root:
            return root
        
        #Recurse both the left and right trees
        l=self.lowestCommonAncestor(root.left,p,q)
        r=self.lowestCommonAncestor(root.right,p,q)
        
        #If we get both the l and r then that means root is the ancestor so return root
        if l and r:
            return root
        else:
            #Return l or r either of which is nor None
            return l or r