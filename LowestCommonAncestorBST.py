#// Time Complexity : O(h) 
# // Space Complexity : O(h) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : No.

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root is None:
            return None
      
        if p.val < root.val and q.val < root.val:
            return self.lowestCommonAncestor(root.left,p,q)
        if p.val > root.val and q.val > root.val:
            return self.lowestCommonAncestor(root.right,p,q)
        
        return root

# Approach:
# The problem can be solved using a recursive approach. We start by checking if the root is None.
# If the root is None, we return None as there is no common ancestor.
# If both p and q are less than the root, we recursively call the function on the left child
# If both p and q are greater than the root, we recursively call the function on the right child
# If p is less than the root and q is greater than the root, or vice versa, we
# return the root as it is the lowest common ancestor. This is because the root is the first node
# that is greater than both p and q, or less than both p and q. Therefore, it
# is the lowest common ancestor of p and q.