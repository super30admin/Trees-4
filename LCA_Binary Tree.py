#Time Complexity: O(n)
#Space Complexity : O(h)
class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        # Base case: if root is None or root matches either p or q, return root
        if not root or root == p or root == q:
            return root
        
        # Recur for left and right subtrees
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)
        
        # If both left and right are not None, then p and q are found in different subtrees
        if left and right:
            return root
        
        # Otherwise, return the non-null result from left or right
        return left if left else right
        