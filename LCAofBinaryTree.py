# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root == None:
            return root
        self.pathp = []
        self.pathq = []
        self.dfs(root, p , q , [])
        lca = 0
        l = min(len(self.pathp), len(self.pathq))
        for i in range(l):
            if self.pathp[i] == self.pathq[i]:
                lca = self.pathp[i]
        return lca

    def dfs(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode', path : list['TreeNode']) -> None:
        if root == None:
            return []
        
        path.append(root)
        if root == p:
            self.pathp = [i for i in path]
            self.pathp.append(root.val)
        if root == q:
            self.pathq = [i for i in path]
            self.pathq.append(root.val)
        
        self.dfs(root.left , p , q, path)
        self.dfs(root.right,p , q, path)
        path.pop()


        