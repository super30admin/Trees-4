-------------------------------- Lowest Common Ancester in Binary Search tree ---------------------------------------------
# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No
# 
# I will iterate through the tree and check for the property of BST. if both p and q are less than root, check in the left subtree.
# If p and q both are greater than root, then check in the right subtree. else return root.



class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if not root:
            return None

        if p.val<=root.val<=q.val:
            return root

        if p.val<root.val and q.val<root.val:
            return self.lowestCommonAncestor(root.left, p,q)
        if p.val>root.val and q.val>root.val:
            return self.lowestCommonAncestor(root.right, p,q)
        return root