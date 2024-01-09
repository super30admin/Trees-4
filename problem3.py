"""
Time Complexity : O(n) where n is the total number of nodes in the tree. In worst case we have to traverse all the nodes in the tree
Space Complexity : O(h) where h is the height of the tree. In worst case the recursive stack can have at max h elements
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Approach:
Inorder traversal of the tree and stop when count reaches to k
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution:
    def __init__(self):
        self.result = 0
        self.counter = 0

    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        if root == None:
            return root
        self.helper(root, k)
        return self.result

    def helper(self, root, k):
        # base
        if root == None:
            return

        # logic
        if self.counter <= k:
            self.helper(root.left, k)
            self.counter += 1
            if self.counter == k:
                self.result = root.val
            self.helper(root.right, k)
