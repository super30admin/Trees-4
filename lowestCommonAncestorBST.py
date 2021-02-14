class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        '''
        Time Complexity: O(logn)
        Space Complexity: O(1)
        '''
        if(p.val<q.val):
            return self.lowestCommonAncestor(root, q, p)
        
        # p is greater and q is smaller
        if(root.val<=p.val and root.val>=q.val):
            return root
        
        if(root.val>p.val and root.val>q.val):
            return self.lowestCommonAncestor(root.left, p, q)
        else:
            return self.lowestCommonAncestor(root.right, p, q)
