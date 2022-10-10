# Time Complexity: O(h)
# Space Complexity: O(h)

# ----------------------------------------Iterative Approach------------------------------------
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        while True:
            if root.val > p.val and root.val > q.val: 
                root = root.left
            elif root.val < p.val and root.val < q.val: 
                root = root.right
            else: return root

# ----------------------------------------Recursive Approach------------------------------------
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root.val > p.val and root.val > q.val: 
            return self.lowestCommonAncestor(root.left, p, q)
        elif root.val < p.val and root.val < q.val: 
            return self.lowestCommonAncestor(root.right, p, q)
        else: return root

