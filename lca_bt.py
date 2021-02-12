# Time complexity - O(h) where h: height of the tree
# Space Complexity: O(h)
# Did this code successfully run on LeetCode?: Yes
# Problems faced while coding this:None
 
 class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        if root is None or root == p or root == q:
            return root
        
        
        left = self.lowestCommonAncestor(root.left,p,q)
        right = self.lowestCommonAncestor(root.right,p,q)
        
        # The following are four conditions to traverse and find the Lowest Common Ancestor.
        if left is not None and right is not None:
            return root
        
        elif left is not None:
            return left
        
        elif right is not None:
            return right
        
        else:
            return None
        