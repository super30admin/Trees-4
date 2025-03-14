# Time O(n)
# Space O(n)
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        return self.LCA(root, p, q)

    def LCA(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        # base
        if root == None or root == p or root == q: 
            return root

        left = self.LCA(root.left, p, q)
        right = self.LCA(root.right, p, q)

        if left == None and right == None: return None
        if left != None and right == None: return left
        if left == None and right != None: return right
        if left != None and right != None: return root

# Time O(n)
# Space O(n)
class Solution:
    def __init__(self):
        self.pathP = []
        self.pathQ = []

    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        self.dfs(root, p, q, [])
        for i in range(len(self.pathQ)):
            if self.pathQ[i] != self.pathP[i]:
                return self.pathQ[i-1]
        return None

    def dfs(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode', path: List['TreeNode']) -> None:
        path.append(root)
        # base
        if root == None: return 
        if root == p: 
            self.pathP = path.copy()
            self.pathP.append(p)
        if root == q: 
            self.pathQ = path.copy()
            self.pathQ.append(q)
        #left
        self.dfs(root.left, p, q, path)
        path.pop()
        #right
        self.dfs(root.right, p, q, path)
        path.pop()   