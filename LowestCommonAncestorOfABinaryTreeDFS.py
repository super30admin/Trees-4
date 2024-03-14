'''
TC: O(n) - n is the number of nodes
SC: O(h) - h is the height of the binary search tree
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        

        def dfs(root):
            if not root:
                return None
            if root == p or root == q:
                return root
            left = dfs(root.left)
            right = dfs(root.right)
            if left and right:
                return root
            elif left:
                return left
            elif right:
                return right
            else:
                return None
        
        return dfs(root)