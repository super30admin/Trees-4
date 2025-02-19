# Time complexity - O(h) -> O(logn) for perfect/complete BST
# Space complexity - O(h)

# Approach - Run dfs on the BST, make use of the property that for root to be 
# lowest common ancestor, root.left < root < root.right. Return root in that case.

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', \
        q: 'TreeNode') -> 'TreeNode':
        if root == None:
            return root
        return self.dfs(root, p, q)
    
    def dfs(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root == None:
            return root
        if root.val < p.val and root.val < q.val:
            return self.dfs(root.right, p, q)
        elif root.val > p.val and root.val > q.val:
            return self.dfs(root.left, p, q)
        else:
            return root