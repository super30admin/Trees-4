#TimeComplexity:O(N) 
#SpaceComplexity: O(Depth)
#Did this code successfully run on Leetcode : Yes 
#Any problem you faced while coding this : No
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root==None:
            return None
        if root==p or root==q:#if root is wither p or q return root
            return root
        
        left=self.lowestCommonAncestor(root.left,p,q)#we will get a value from left if p or q exists else we will get None
        right=self.lowestCommonAncestor(root.right,p,q)# similarly for right
        
        if left!=None and right!=None:#Finally if both are not null it means root is the answer as each of p, q are present to either sides of root
            return root
        elif left!=None:#Here both are present to the left hence only left is not none and right is None
            return left
        else: #else they are present to the right side
            return right
        