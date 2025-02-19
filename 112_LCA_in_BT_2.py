# Time complexity - O(n)
# Space complexity - O(h)

# Approach - Bottom-up recursion - Run dfs on root.left and root.right. If p or q
# found, then return root to the parent, otherwise return None.

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode')\
        -> 'TreeNode':
        if root == None or root == p or root == q:
            return root
        
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)

        if left == None and right == None:
            return None
        elif left != None and right == None:
            return left
        elif left == None and right != None:
            return right
        else:
            return root