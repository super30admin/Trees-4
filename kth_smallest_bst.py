# Time Complexity : O(n)
# Space Complexity : O(n) considering stack space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
# I do inorder traversal and maintain previous node and whenever the previous node valus is smaller than the current node. I store prev and current node. If 
# no other breaches happen return this else I assign the next current to the previous current and return both the variables

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def inorder(self, root):
        if not root:
            return 
        
        found = self.inorder(root.left)
        if found is not None:
            return found
        self.k -= 1
        if self.k == 0:
            return root.val
        else:
            return self.inorder(root.right)

        
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        self.k = k
        return self.inorder(root)
