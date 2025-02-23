#time: O(n)
#space: O(h)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        return self.dfs(root,p,q)
        

    def dfs(self, root,p,q):
        if root is None:
            return root
        print(root.val)
        if (root.val > p.val and root.val > q.val): 
            return self.dfs(root.left,p,q)
        if (root.val < q.val and root.val < p.val):
            return self.dfs(root.right,p,q)
        return root
    

        
