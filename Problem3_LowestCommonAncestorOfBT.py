# Time Complexity: O(n), where n - number of nodes in the tree
# Space Complexity: O(h), where h - height of the tree

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        # base
        if not root or root == p or root == q:
            return root

        # logic
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)

        # if both p and q are found, then the root node is the LCA
        if left and right:
            return root
        elif left:
            return left
        else:
            return right