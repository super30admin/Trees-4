"""
## Problem1 Kth Smallest Element in a BST (https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/)

Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note:
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Example 1:

Input: root = [3,1,4,null,2], k = 1


       3


      / \


    1   4


      \


       2

Output: 1
Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3


             5


            / \


          3    6


          / \


         2   4


       /


    1

Output: 3


TIME- O(maxdepth)
SPACE - O(maxdepth)

"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        stack = []
        count = 0
        while root != None or stack != []:
            while root != None:   #go left left left and keep append the roots to stack
                stack.append(root)
                root = root.left

            top = stack.pop()         # at en dof left start poping
            count += 1       # keep count of pops, popped element will be in ascending order - inorder of BST
            if k == count:      # when count is equal to k RETURN TOP.VAL
                return top.val

            root = top.right        # AFTER POP go to right of popped/top node


