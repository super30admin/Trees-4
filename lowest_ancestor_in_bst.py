# // Time Complexity : O(h)
# // Space Complexity : O(h)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Nope
 

# // Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

#################Recursive Solution###################

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        #If both values are bigger than root go to right
        if p.val>root.val and q.val>root.val:
            return self.lowestCommonAncestor(root.right,p,q)
        #If both values are small go to left
        elif p.val<root.val and q.val<root.val:
            return self.lowestCommonAncestor(root.left,p,q)
        #if any one value is the root value then return the root
        else:
            return root


################Iterative Solution #####################

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        #Until we reach the leaf
        while True:
            #Same conditions llike reccusive
            if p.val>root.val and q.val>root.val:
                root= root.right
            elif p.val<root.val and q.val<root.val:
                root=root.left
            else:
                return root