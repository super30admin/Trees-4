# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        ppath = []
        qpath = []
        def dfs(root,p,q,path):
            if not root:
                return
            path.append(root)
            if root.val == p.val:
                ppath.extend(list(path))
            if root.val == q.val:
                qpath.extend(list(path))
            
            dfs(root.left,p,q,path)
            dfs(root.right,p,q,path)
            path.pop()

        dfs(root,p,q,[])
        i = 0
        while i <len(ppath) and i < len(qpath):
            if ppath[i].val != qpath[i].val:
                return ppath[i-1]
            i += 1
        return ppath[i-1]
        