# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def __init__(self):
        self.path1 = []
        self.path2 = []
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
            self.backtrack(root, p, self.path1)
            self.backtrack(root, q, self.path2)
            for i in range(len(self.path1)):
                if self.path1[i]!=self.path2[i]:
                    return self.path2[i-1]
            
            return None
    
    def backtrack(self,root, p, path):
        #base
        if root ==  None:
            return
        if root == p:
            path.append(root)
            path.append(root)
            return
        #action
        path.append(root)
        #recurse
        self.backtrack(root.left, p, path)
        self.backtrack(root.right, p, path)
        if p == path[len(path)-1]:
            return
        #backtrack
        path.pop()
            
        
