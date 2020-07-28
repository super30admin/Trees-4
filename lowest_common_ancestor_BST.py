# Time Complexity : Add - O(log N)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''
1. o an in order traversal while checking if p lies on left and if q lies on right, if it does return root
2. But if not, we check if both p,q lies on left, if they do recurse on left
3. Else recurse on right
'''


class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        return self._helper(root, p, q)
        
        
    def _helper(self, root, p, q):
        
        if root is None:
            return
        
        if p.val < root.val and q.val < root.val:
            return self._helper(root.left, p, q)
            
        elif p.val > root.val and q.val > root.val:
            return self._helper(root.right, p, q)
        
        else:
            return root
        