# Time Complexity : O(H+K)
# Space Complexity : O(H)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using inroder traversal. Iterate over the binary search tree and initialize a stack with the root
# Perform inorder traversal by popping elements from the stack and visiting each node and decrementing value of k when the element is visited
# Return node.val when k is 0

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: TreeNode | None, k: int) -> int:
        if not root:
            return None
        stack = [(root, False)]
        count = 0
        while stack:
            node, visited = stack.pop()
            if node:
                if visited:
                    k -= 1
                    if k == 0:
                        return node.val
                else:
                    stack.append((node.right, False))
                    stack.append((node, True))
                    stack.append((node.left, False))
        return -1

                    
