# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        """
        Approach:
        1. Use DFS to traverse the tree; return the node itself if it's equal to p or q.
        2. Recursively check left and right subtrees — if both return non-null, current node is the LCA.
        3. If only one side returns non-null, propagate that node up as it may be the ancestor.

        Time Complexity: O(N), where N is the number of nodes in the tree — we visit each node once.
        Space Complexity: O(H), where H is the height of the tree — for the recursion stack (O(log N) for balanced, O(N) for skewed).
        """

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
