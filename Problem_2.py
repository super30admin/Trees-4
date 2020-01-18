# Runs on Leetcode
  # n is number of nodes, h is height of tree
    # Solution 1
        # Runtime - O(n)
        # Memory - O(h) considering the recursive stack
    # Solution 2
        # Runtime - O(n)
        # Memory - O(1)


# Solution 1

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode'):
        if not root:
            return root
        
        if p.val < root.val and q.val < root.val:
            return self.lowestCommonAncestor(root.left, p, q)
        
        elif p.val > root.val and q.val > root.val:
            return self.lowestCommonAncestor(root.right, p, q)
        
        return root
        
# Solution 2
        
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode'):
        if not root:
            return root
        
        while root:
            if p.val < root.val and q.val < root.val:
                root = root.left

            elif p.val > root.val and q.val > root.val:
                root = root.right
                
            else:
                return root
