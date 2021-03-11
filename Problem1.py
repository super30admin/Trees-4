"""
230. Kth Smallest Element in a BST
Time Complexity - O(n)
Space Complexity - O(Depth of tree)
This is a iterative solution where we make a stack and as we know if we traverse tree in inorder then we will be able to get Tree in sorted pattern then after push elements till the left last element start poping element and decrement k if k == 0 then if means poped elemnt is output else push right element of poped element"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        stack = []
        while(stack or root != None):
            while(root != None):
                stack.append(root)
                root = root.left
            top = stack.pop()
            k -= 1
            if k == 0:
                return top.val
            root = top.right
        return -1
        