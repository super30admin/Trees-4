# Time Complexity - O(n)
# Space Complexity - O(h)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if not root: 
            return None

        self.pathP = []
        self.pathQ = []

        self.backtrack(root,p,q,[])

        for i in range(len(self.pathP)):
            if self.pathP[i] != self.pathQ[i]:
                return self.pathP[i-1]

       

    def backtrack(self,root,p,q,path): 
        path.append(root)

        if(root == p):
            self.pathP = path.copy()
            self.pathP.append(p)
        if(root == q):
            self.pathQ = path.copy()
            self.pathQ.append(q)

        
        if root.left:
            self.backtrack(root.left, p, q, path)
        if root.right:
            self.backtrack(root.right, p, q, path)

        path.pop()

# Without using paths

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if not root or root == p or root == q: 
            return root 

        left = self.lowestCommonAncestor(root.left,p,q) 
        right = self.lowestCommonAncestor(root.right,p,q) 
        if not left and not right:
            return None
        elif not left and right : 
            return right 
        elif left and not right:
            return left
        elif left and right:
            return root
        

       

    
