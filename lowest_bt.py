# The lowestCommonAncestor method finds the lowest common ancestor of two nodes in a binary tree.

# Use a recursive DFS approach:
# - If the current node is None or matches one of the target nodes, return it.
# - Recursively check the left and right subtrees.
# - If both left and right subtrees return non-None, the current node is the LCA.
# - Otherwise, return the non-None result from the left or right subtree.

# TC: O(n) - Each node is visited once.
# SC: O(h) - Space for the recursion stack, where h is the tree height.


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def lowestCommonAncestor(self, root: TreeNode, p: TreeNode, q: TreeNode) -> TreeNode:
        def dfs(node):
            if not node:
                return None
            if node == p or node == q:
                return node
            left = dfs(node.left)
            right = dfs(node.right)
            if left and right:
                return node
            return left if left else right
        return dfs(root)
