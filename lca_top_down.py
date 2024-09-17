# // Time Complexity :O(n)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no



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
        self.helper(p,q,root,[])
        
        print("a")
        for i in range(len(self.pathp)):
            print(i)
            if self.pathp[i] is not self.pathq[i]:
                
                return self.pathp[i-1]
        
    def helper(self,p,q,root,path):
        #base
        if root is None:
            return
        #logic
    
        path.append(root)
        
        
        if root.val == p.val:
            self.pathp=copy.copy(path)
            self.pathp.append(p)
            
        if root.val == q.val:
            self.pathq=copy.copy(path)
            self.pathq.append(q)
            
        self.helper(p,q,root.left,path)
        self.helper(p,q,root.right,path)
    
        path.pop()
            
            
        
        