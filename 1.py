'''
Trees-4

Problem1 Kth Smallest Element in a BST (https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/)
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int: # type: ignore
        if root == None:
            return -1

        self.count = 0
        self.result = -1
        self.inorder(root, k)
        return self.result

    def inorder(self, root:Optional[TreeNode], k:int) -> None: # type: ignore
        #base
        if root == None or self.result != -1:
            return

        #logic
        self.inorder(root.left, k)
        self.count = self.count + 1
        if self.count == k:
            self.result = root.val
            return
        self.inorder(root.right, k)            