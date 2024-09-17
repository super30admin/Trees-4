# // Time Complexity :O(n)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach


import copy
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def __init__(self):
        self.pathq=[]
        self.pathp=[]
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        print(p.val)
        print(q.val)
        return self.helper(p,q,root)
        
        
        
    def helper(self,p,q,root):
        #base
        if root is None or root==p or root==q:
            print(root)
            print("a")
            return root
        #logic
    
        left=self.helper(p,q,root.left)
        right=self.helper(p,q,root.right)
        print(left)
        print(right)
        if left is None and right is None:
            return None
        elif left is None and right is not None:
            return right
        elif right is None and left is not None:
            return left
        else:
            return root
            
        
        