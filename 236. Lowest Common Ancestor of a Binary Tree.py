# Aprroach 1
# storing the path and then traversing
#space: O(h)
#time: O(n)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        self.pl=list()
        self.ql= list()
        self.dfs(root, list(),p,q)
        for i in range(0,len(self.pl)):
            if self.ql[i+1] != self.pl[i+1]:
                return self.pl[i]

    def dfs(self, root, path,p,q):
        if root is None:
            return
        path.append(root)
        if root == p:
            self.pl= path.copy()
            self.pl.append(root)
        if root == q:
            self.ql= path.copy()
            self.ql.append(root)
        self.dfs(root.left, path,p,q)
        self.dfs(root.right, path,p,q)
        path.pop(-1)
        return

# aproach 2
# return the matched value in left and right subtree, the moment when both values are found then that node is the LCA
# Definition for a binary tree node.
# Time: O(n)
#Space: O(1
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        return self.dfs(root,p,q)

    def dfs(self, root,p,q):
        if root  is None or root ==p or root==q:
            return root
        left = self.dfs(root.left, p,q)
        right= self.dfs(root.right, p,q)
        if ( left == None and right == None):
            return None
        if ( left != None and right == None):
            return left
        if ( left == None and right != None):
            return right
        return root

        
