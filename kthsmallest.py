""" Time : O(logN)
    Space : O(1)
    Leetcode : Yes
    Explanation : If we recurse through left and decrement everytime we see a node in dfs, then when we reach the top, we should have reached the 
    lth smallest element. Where l = no. of elements in left tree.
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        
        self.count = k
        self.result = 0 
        self.recurse(root)
        return self.result
    
    def recurse(self, root):

        if root.left:
            self.recurse(root.left)

        self.count -= 1
        if self.count == 0:
            self.result = root.val
            return

        if root.right:
            self.recurse(root.right)
