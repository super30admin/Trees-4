# Time Complexity : O(h) where h is the height of the binary tree
# Space Complexity : O(h) where h is the height of the binary tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach:
# I am using recursion to do an inorder traversal of the BST. I will decrement k whenever I visit a node.
# When k becomes 0, I have reached the kth smallest element and will store the value of that node as the answer.
# In the end, I will return the answer.

from typing import Optional
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.k = k
        self.ans = None
        def helper(root):
            if not root:
                return 
            helper(root.left)
            self.k -= 1
            if self.k == 0:
                self.ans = root.val
                return 
            helper(root.right)
        helper(root)
        return self.ans