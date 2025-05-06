# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

# Time Complexity : O(logN)
# Space Complexity : O(h)
# Approach:
# 1. Traverse the BST starting from the root.
# 2. If both p and q are less than the current node, move to the left subtree.
# 3. If both p and q are greater than the current node, move to the right subtree.
# 4. If one of p or q is less than the current node and the other is greater, we have found the LCA.
# 5. If one of p or q is equal to the current node, we have found the LCA.
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if p.val < root.val and q.val < root.val:
            return self.lowestCommonAncestor(root.left, p, q)
        elif p.val > root.val and q.val > root.val:
            return self.lowestCommonAncestor(root.right, p, q)
        else:
            return root

# Time Complexity : O(logN)
# Space Complexity : O(1)
# Approach:
# This approach is similar to the above approach, but it uses an iterative method instead of recursion.
# 1. Start from the root and traverse the BST.
# 2. If both p and q are less than the current node, move to the left subtree.
# 3. If both p and q are greater than the current node, move to the right subtree.
# 4. If one of p or q is less than the current node and the other is greater, we have found the LCA.
# 5. If one of p or q is equal to the current node, we have found the LCA.
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        while True:
            if p.val < root.val and q.val < root.val:
                root = root.left
            elif p.val > root.val and q.val > root.val:
                root = root.right
            else:
                return root