"""
Time Complexity: O(N)
Space Complexity: O(1)
Compiled on leetcode?: Yes
"""
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root is None or root==p or root == q:
            return root
        else:
            left = self.lowestCommonAncestor(root.left, p, q)
            
            right = self.lowestCommonAncestor(root.right, p, q)
            if left and right:
                return root
            if left is None and right is None:
                return None
            elif left:
                return left
            else:
                return right