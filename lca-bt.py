'''
Time Complexity: O(n)
Space Complexity: O(h)
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        def preorder(root):
            if(not root):
                return None
            if(root == p or root==q):
                return root
            v1 = preorder(root.left)
            v2 = preorder(root.right)
            if(v1 and v2):
                return root
            return v1 or v2
        return preorder(root)
        