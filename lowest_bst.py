# The lowestCommonAncestor method finds the lowest common ancestor of two nodes in a binary search tree (BST).

# Use an iterative approach:
# - Traverse the tree starting from the root.
# - If both nodes are greater than the current node, move to the right subtree.
# - If both nodes are smaller, move to the left subtree.
# - Otherwise, the current node is the lowest common ancestor.

# TC: O(h) - Traversal depends on the height of the tree.
# SC: O(1) - Constant space usage.


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def lowestCommonAncestor(self, root: TreeNode, p: TreeNode, q: TreeNode) -> TreeNode:
        cur = root

        while cur:
            if p.val > cur.val and q.val > cur.val:
                cur = cur.right
            elif p.val < cur.val and q.val < cur.val:
                cur = cur.left
            else:
                return cur