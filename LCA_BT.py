# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    """
    TC:O(n), n = all the nodes
    SC:O(h), h=height
    """
    def __init__(self):
        self.path1=[]
        self.path2=[]
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        self.backtrack(root, p,q, [])
        for i in range(len(self.path1)):
            if self.path1[i]!=self.path2[i]:
                return self.path1[i-1]
        return -1
    
    def backtrack(self,root, p,q,path):
        # base
        if root is None: return
        
        if root == p:
            self.path1=path.copy()
            self.path1.append(p)
            self.path1.append(p)
            
        if root == q:
            self.path2=path.copy()
            self.path2.append(q)
            self.path2.append(q)
            
        print(root.val)
        # logic
        # action
        path.append(root)
        # recurse
        # if len(self.path1)==0 or len(self.path2)==0:
        self.backtrack(root.left, p,q,path)

        if len(self.path1)==0 or len(self.path2)==0:
            self.backtrack(root.right,p,q,path)
        
        # backtrack
        path.pop()
        