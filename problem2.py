# Time Complexity : O(log(n)), n-> nodes in tree
# Space Complexity : O(h)
# Did this code successfully run on Leetcode : YES

# Any problem you faced while coding this : NO

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        def dfs(root):
            if root.val < p.val and root.val < q.val:
                return dfs(root.right)
            elif root.val > p.val and root.val > q.val:
                return dfs(root.left)
            else:
                return root
        
        return dfs(root)