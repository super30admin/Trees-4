# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

#TC: O(n)
#SC : O(h)
class Solution:
    def __init__(self):
        self.path_p = []
        self.path_q = []
        self.flag_p = False
        self.flag_q = False
        
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if not root:
            return None
        
        def backtrack(root,p,q,path):
            if not root:
                return
            if root == p:
                self.path_p = list(path)
                self.path_p.append(root)
                self.path_p.append(root)
                self.flag_p = True
            
            if root == q:
                self.path_q = list(path)
                self.path_q.append(root)
                self.path_q.append(root)
                self.flag_q = True
            #Logic
            #Action
            path.append(root)
            if not self.flag_p or not self.flag_q:
                backtrack(root.left,p,q,path)
            if not self.flag_p or not self.flag_q:
                backtrack(root.right,p,q,path)
            #backtrack
            path.pop()
        
        backtrack(root,p,q,[])
        
        l1 = len(self.path_p)
        l2 = len(self.path_q)
        
        n = min(l1,l2)
        for i in range(n):
            if self.path_p[i] != self.path_q[i]:
                return self.path_p[i-1]
        
        