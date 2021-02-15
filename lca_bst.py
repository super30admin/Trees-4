class Solution:
    
    """
    Description: LCA for a binary tree
    
    Time complexity: O(log n)
    Space complexity: O(h)
    
    Approach:
    - go either left or right based on the values of p and q
    - return root if both values are not on either side
    """

    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if p.val < root.val and q.val < root.val:
            return self.lowestCommonAncestor(root.left, p, q)
        elif p.val > root.val and q.val > root.val:
            return self.lowestCommonAncestor(root.right, p, q)
        else:
            return root
