# Time: O(logn)
# Space: O(1)
# Iterative approach

class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        while root:
            if p.val > root.val and q.val > root.val:
                root = root.right
            elif p.val < root.val and q.val < root.val:
                root = root.left           
            else:
                return root
        return None
   
# Time: O(logn)
# Space: O(N)
# Recursive approach

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if p.val > root.val and q.val > root.val:
            return self.lowestCommonAncestor(root.right, p, q)
        elif p.val < root.val  and q.val < root.val:
            return self.lowestCommonAncestor(root.left, p, q)
        else:
            return root
