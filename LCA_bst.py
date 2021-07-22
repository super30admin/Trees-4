# Time Complexity : O(H)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root==None:
            return
        
        while(True):
            if p.val<root.val and q.val<root.val:
                root=root.left
            elif p.val>root.val and q.val>root.val:
                root=root.right
            else:
                return root
            