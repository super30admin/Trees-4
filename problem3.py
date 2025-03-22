# Time Complexity : O(n), n-> nodes in tree
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
            if not root or root == p or root == q:
                return root
            
            left = dfs(root.left)
            right = dfs(root.right)

            if left and not right:
                return left
            elif right and not left:
                return right
            elif not left and not right:
                return None
            else:
                return root
        
        return dfs(root)
            