"""
Bottom Up recursion
TC: O(n)
SC: O(h)
"""
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if not root: return None
        if root in [p,q]: return root

        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)
        
        if left and right: return root
        else: return left if left else right

"""
Brute Foce
TC: O(n)
SC: O(h)
"""
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        pPath = []
        qPath = []
        path = []

        def dfs(cur):
            if not cur: return
            nonlocal pPath, qPath, p, q, path

            path.append(cur)
            if cur == p:
                pPath = copy.copy(path)
            if cur == q:
                qPath = copy.copy(path)
            
            dfs(cur.left)
            dfs(cur.right)
            path.pop()

        dfs(root)

        if len(pPath) > len(qPath): pPath,qPath = qPath,pPath
        for i in range(len(pPath)):
            if pPath[i] != qPath[i]:
                return pPath[i-1]

        return pPath[-1]