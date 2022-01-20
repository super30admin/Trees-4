class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        # Recursive Solution
        # Time Complexity - O(h) where h is the height of the tree
        # Space Complexity - O(h) for recursive stack
        if not root:
            return root
        if root.val > p.val and root.val > q.val:
            return self.lowestCommonAncestor(root.left, p, q)
        elif root.val < p.val and root.val < q.val:
            return self.lowestCommonAncestor(root.right, p, q)
        else:
            return root

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        # Iterative Solution
        # Time Complexity - O(h) where h is the height of the tree
        # Space Complexity - O(1) as there's no stack
        while root:
            if max(p.val, q.val) < root.val:
                root = root.left
            elif min(p.val, q.val) > root.val:
                root = root.right
            else:
                return root