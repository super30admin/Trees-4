"""
Time complexity O(3n)
Space O(M+N) for path1 and path2 list and recursive stack space 


"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution_LCApath:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        path1=[]
        path2=[]
        self.backtrack(root,p,path1)
        self.backtrack(root,q,path2)
        print(path1)
        print(path2)
        for i in range(len(path1)):
            if(path1[i]!=path2[i]):
                return path1[i-1]
        return None
    
    def backtrack(self,root,p,path):
        #base 
        if root is None:
            return
        if(root==p):
            path.append(root)
        #logic
        #action 
        path.append(root)
        self.backtrack(root.left,p,path)
        if(path[-1]==p):
            return
        self.backtrack(root.right,p,path)
        if(path[-1]==p):
            return
        path.pop()
        
        
        