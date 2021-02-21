# Time Complexity : O(H)
# Space Complexity : O(H)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using inroder traversal. Iterate over the binary search tree and initialize a stack with the root
# Perform inorder traversal by popping elements from the stack and visiting each node and decrementing value of k when the element is visited
# Add to res when k becomes 1 and return res


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        if not root:
            return None
        stack = [(root, False)]
        res = -1
        while stack:
            node, visited = stack.pop()
            if node:
                if visited:
                    if k == 1:
                        res = node.val
                    k -= 1
                else:
                    stack.append((node.right, False))
                    stack.append((node, True))
                    stack.append((node.left, False))
        return res