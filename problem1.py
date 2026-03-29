# problem 1 

# https://leetcode.com/problems/kth-smallest-element-in-a-bst/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:

    def helper(self,root):
        if root is None:
            return
        self.final_arr.append(root.val)
        self.helper(root.left)
        self.helper(root.right)
        

    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.final_arr = []
        self.helper(root)
        self.final_arr.sort()
        return self.final_arr[k-1]