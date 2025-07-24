# ----------------------------------------------------
# LeetCode 235. Lowest Common Ancestor of a Binary Search Tree
#
# Intuition:
# In a BST, the LCA of two nodes `p` and `q` is the node where:
# - One node lies in the left subtree and the other in the right, OR
# - One of the nodes is equal to the current node.
# 
# Traverse the tree:
# - If both `p` and `q` are smaller than current node -> go left.
# - If both are greater -> go right.
# - Else, current node is the split point — the LCA.
#
# ----------------------------------------------------
from typing import Optional

class TreeNode:
    def __init__(self, val: int, left: Optional['TreeNode']=None, right: Optional['TreeNode']=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:

    # ----------------------------------------------------
    # 1. Iterative Solution
    # Time: O(h), where h = height of the BST (worst-case O(n) if skewed)
    # Space: O(1)
    # ----------------------------------------------------
    def lowestCommonAncestor_iterative(self, root: TreeNode, p: TreeNode, q: TreeNode) -> TreeNode:
        curr = root

        while curr:
            # Both nodes lie in left subtree
            if max(p.val, q.val) < curr.val:
                curr = curr.left
            # Both nodes lie in right subtree
            elif min(p.val, q.val) > curr.val:
                curr = curr.right
            else:
                # Current node is the split point
                return curr
        return None  # In case tree is empty or nodes not found


    # ----------------------------------------------------
    # 2. Recursive Solution
    # Time: O(h), where h = height of the BST (worst-case O(n) if skewed)
    # Space: O(h) due to recursion stack (worst-case O(n) if skewed)
    # ----------------------------------------------------
    def lowestCommonAncestor_recursive(self, root: TreeNode, p: TreeNode, q: TreeNode) -> TreeNode:
        if not root:
            return None

        if max(p.val, q.val) < root.val:
            # LCA must be in left subtree
            return self.lowestCommonAncestor_recursive(root.left, p, q)
        elif min(p.val, q.val) > root.val:
            # LCA must be in right subtree
            return self.lowestCommonAncestor_recursive(root.right, p, q)
        else:
            # Current node is the split point
            return root


# ----------------------------------------------------
# Example Usage
# ----------------------------------------------------
if __name__ == "__main__":
    # Build a sample BST:
    #         6
    #       /   \
    #      2     8
    #     / \   / \
    #    0   4 7   9
    #       / \
    #      3   5

    node3 = TreeNode(3)
    node5 = TreeNode(5)
    node4 = TreeNode(4, node3, node5)
    node0 = TreeNode(0)
    node2 = TreeNode(2, node0, node4)
    node7 = TreeNode(7)
    node9 = TreeNode(9)
    node8 = TreeNode(8, node7, node9)
    root = TreeNode(6, node2, node8)

    sol = Solution()
    lca = sol.lowestCommonAncestor_iterative(root, node2, node8)
    print(f"LCA: {lca.val}")  # Output: 6
