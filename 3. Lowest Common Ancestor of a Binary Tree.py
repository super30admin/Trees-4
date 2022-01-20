class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        # Time Complexity - O(n)
        # Space Complexity  - O(h) - where h is the height of the tree and the space is because of the recursive stack
        if root is None or root == p or root == q:
            return root

        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)

        if left is None and right is None:
            return None
        elif left is None and right is not None:
            return right
        elif right is None and left is not None:
            return left
        else:
            return root