# Time Complexity : Add - O(N
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''
1. Find left and right elemnent if root is non, or p,q is found
2. if both left and right are not null, it means p,q has ben found, thus retuen the root
3. Else return the non-null element
'''


class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        return self._helper(root, p, q)
        
        
    def _helper(self, root, p, q):
        
        if root is None or root.val == p.val or root.val == q.val:
            return root
        
        left = self._helper(root.left, p, q)
        right = self._helper(root.right, p, q)
        
        if left is not None and right is not None:
            return root
        elif left:
            return left
        elif right:
            return right
        else:
            return None
        
        
        