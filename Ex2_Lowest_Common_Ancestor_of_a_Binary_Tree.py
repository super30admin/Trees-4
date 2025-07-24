# ----------------------------------------------------
# LeetCode 236. Lowest Common Ancestor of a Binary Tree
#
# Intuition:
# 
# 1. Optimized Recursive DFS:
#    - Recursively traverse left and right subtrees.
#    - If current node matches p or q, return current node.
#    - If both left and right recursive calls return non-null nodes,
#      current node is LCA.
#    - Else return the non-null return value (either LCA from subtree or None).
#
# 2. Naive Path-Finding Approach:
#    - Find path from root to p and root to q.
#    - Compare paths to find last common node.
#    - Simpler but requires extra space and two traversals.
#
# ----------------------------------------------------
from typing import Optional, List

class TreeNode:
    def __init__(self, val: int, left: Optional['TreeNode']=None, right: Optional['TreeNode']=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:

    # ----------------------------------------------------
    # 1. Optimized Recursive DFS Approach
    # Time: O(n), where n = number of nodes (visit each node once)
    # Space: O(h), recursion stack height (worst O(n) skewed tree)
    # ----------------------------------------------------
    def lowestCommonAncestor(self, root: TreeNode, p: TreeNode, q: TreeNode) -> TreeNode:
        # Base case
        if not root or root == p or root == q:
            return root
        
        # Search left and right subtrees
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)

        # If both sides returned non-null, root is LCA
        if left and right:
            return root
        
        # Otherwise return non-null child (either LCA or None)
        return left if left else right

    # ----------------------------------------------------
    # 2. Naive Path-Finding Approach
    # Time: O(n) — Must traverse tree to find both paths
    # Space: O(h) — Recursion stack and path storage, where h is tree height
    # Worst-case: O(n) if tree is skewed (height equals number of nodes)
    # ----------------------------------------------------

    def findPath(self, root, target, path):
        # If reached null node, no path
        if not root:
            return False
        
        # Add current node to path
        path.append(root)
        
        # If target found
        if root == target:
            return True
        
        # Search left or right subtree
        if self.findPath(root.left, target, path) or self.findPath(root.right, target, path):
            return True
        
        # Backtrack if target not found in subtree
        path.pop()
        return False

    def lowestCommonAncestor_pathFinding(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        path_p = []
        path_q = []

        # Find paths from root to p and q
        self.findPath(root, p, path_p)
        self.findPath(root, q, path_q)

        # Compare the paths to find the last common node
        i = 0
        while i < len(path_p) and i < len(path_q) and path_p[i] == path_q[i]:
            i += 1

        return path_p[i - 1]  # Last common ancestor


# ----------------------------------------------------
# Example Usage
# ----------------------------------------------------
if __name__ == "__main__":
    # Build example tree:
    #         3
    #       /   \
    #      5     1
    #     / \   / \
    #    6   2 0   8
    #       / \
    #      7   4

    root = TreeNode(3)
    root.left = TreeNode(5)
    root.right = TreeNode(1)
    root.left.left = TreeNode(6)
    root.left.right = TreeNode(2)
    root.right.left = TreeNode(0)
    root.right.right = TreeNode(8)
    root.left.right.left = TreeNode(7)
    root.left.right.right = TreeNode(4)

    sol = Solution()

    p = root.left      # Node with val 5
    q = root.left.right.right  # Node with val 4

    lca = sol.lowestCommonAncestor(root, p, q)
    print(f"LCA of {p.val} and {q.val}: {lca.val}")  # Output: 5

