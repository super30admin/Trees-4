#The dfs function traverses the tree recursively, starting from the root node. It first checks if the current node is None, returning immediately if so. If the current node matches either of the target nodes (p or q), it returns the node. As the recursion unwinds, if both left and right subtrees return non-null values, it means the current node is the LCA of p and q, so it returns this node. If only one subtree contains a target node, it returns the non-null result from that subtree. The time complexity of this solution is O(N), where N is the number of nodes in the tree, as each node is visited once. The space complexity is O(H), where H is the height of the tree, due to the recursive call stack used during the DFS traversal.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        def dfs(root):
            if not root:
                return

            if root == p or root == q:
                return root

            left, right = (
                dfs(root.left), 
                dfs(root.right),
            )

            if left and right:
                return root

            return right if not left else left

        return dfs(root)
        