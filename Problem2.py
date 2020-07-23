# Time Complexity : O(n) 
# Space Complexity :O(h)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        while root:
            if p.val < root.val and q.val < root.val:
                root = root.left 
            elif p.val > root.val and q.val > root.val:
                root = root.right 
            else:
                return root
            