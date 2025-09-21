#  Time Complexity : O(n)
#  Space Complexity : O(n)
#  Did this code successfully run on Leetcode : Yes
#  Three line explanation of solution in plain english : This code finds the kth smallest element in a Binary Search Tree (BST) using an iterative inorder traversal. It pushes all left nodes onto a stack until reaching the leftmost node, then pops nodes one by one, decrementing k each time since inorder traversal gives nodes in ascending order. When k reaches 0, it returns the current node’s value as the kth smallest element.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        stack = []
        while stack or root:
            while root:
                stack.append(root)
                root = root.left
            
            root = stack.pop()
            k -= 1
            if k == 0:
                return root.val
            
            root = root.right
        return -1