# TC : O(N)
# SC : O(N)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        def traverse(root):
            if p.val < root.val and q.val < root.val:
                traverse(root.left)
            elif p.val > root.val and q.val > root.val:
                traverse(root.right)
            else:
                self.elem = root

        self.elem = None
        traverse(root)
        return self.elem
                
