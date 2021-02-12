# Time complexity - O(h) where h: height of the tree
# Space Complexity: O(1) 
# Did this code successfully run on LeetCode?: Yes
# Problems faced while coding this:None
# Approach : Use property of the bst and traverse accordingly to find the Lowest Common Ancestor.

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root is None:
            return None
        
        while root is not None:
            
            if p.val < root.val and q.val < root.val:
                root = root.left
                
            elif p.val > root.val and q.val > root.val:
                root = root.right
                
            else:
                return root
            
        return None
        
        