# Time Complexity : O(h) where h is the height of the binary tree
# Space Complexity : O(h) where h is the height of the binary tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach:
# I am using recursion to traverse the binary tree. I will check if the current node is either p or q.
# If it is then I will return that node. I will recursively call the left and right subtree.
# If both left and right return a non-null value then I will return the current node as the LCA.
# If only one of them returns a non-null value then I will return that value.
# If both return null then I will return null.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if not root:
            return root
        if root.val == p.val or root.val == q.val:
            return root
        left = self.lowestCommonAncestor(root.left,p,q)
        right = self.lowestCommonAncestor(root.right,p,q)
        if left and right:
            return root
        else:
            return left or right