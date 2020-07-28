-------------------------------- Lowest Common Ancester in Binarytree ---------------------------------------------
# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No
# 
# I will iterate through the tree and check if the root equals to either p or q, if yes, then return root.
#else find whether we will find the p or q in left subtree or right subtree. Check if l is present or r is present,
#return l or r else return both l and r.


class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if not root:
            return None

        if p == root or q == root:
            return root
        
        l = self.lowestCommonAncestor(root.left, p,q)
        r = self.lowestCommonAncestor(root.right, p,q)
        
        if l and r:
            return root
        elif l or r:
            return l or r
            