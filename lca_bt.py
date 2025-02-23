# TC: O(n+h)
# SC: O(h)

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
        self.pPath=[]
        self.qPath=[]
        def dfs(root,path):
            #base
            if not root or (len(self.pPath)>0 and len(self.qPath)>0):
                return
            #logic            
            path.append(root)
            if root==p:
                self.pPath=path[:]
                self.pPath.append(root)
            if root==q:
                self.qPath=path[:]
                self.qPath.append(root)
            dfs(root.left,path)
            dfs(root.right,path)
            path.pop()
        
        dfs(root,[])
        for i in range(len(self.pPath)):
            if self.pPath[i]!=self.qPath[i]:
                return self.pPath[i-1]
        return None



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if not root or root==p or root==q:
            return root
        left =  self.lowestCommonAncestor(root.left,p,q)
        right =  self.lowestCommonAncestor(root.right,p,q)

        if not left and not right:
            return None
        elif left and not right:
            return left
        elif not left and right:
            return right
        else:
            return root