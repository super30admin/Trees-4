# Time Complexity : O(h) where h is the height of the binary tree
# Space Complexity : O(h) where h is the height of the binary tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach:
# I am using the properties of BST to find the LCA. If both p and q are smaller than root then LCA lies in left subtree.
# If both p and q are greater than root then LCA lies in right subtree. If one of them is smaller and the other is greater
# then root is the LCA.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':

        if not root:
            return None
        if root.val < p.val and root.val < q.val:
            return self.lowestCommonAncestor(root.right,p,q)
        if root.val > p.val and root.val > q.val:
            return self.lowestCommonAncestor(root.left,p,q)

        return root






        

