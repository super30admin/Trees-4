"""
TC: O(N)
SP: O(H)

"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        path_p = []
        path_q = []
        def dfs(root, pp):
            nonlocal path_p, path_q
            if not root:
                return
            pp.append(root)
            if root.val==p.val:
                path_p = pp[:]
            if root.val == q.val:
                path_q = pp[:]
            dfs(root.left, pp)
            dfs(root.right, pp)
            pp.pop()
        dfs(root, [])
        i=j=0
        while i <len(path_p) and j<len(path_q) and path_p[i]==path_q[j]:
            i+=1
            j+=1
        return path_p[i-1] if i >0 else path_p[i]
            
