# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#TC: O(n)
#SC: O(h) for stack

#Accepted on Leetcode

#Approach:
#Use an explicit stack to facilitate IO traversal of the BST, since IO traversal will be in ascending order, we know the kth element to be printed will be the kth smallest element
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        count = 0
        stack = []

        while (root != None or len(stack)):
            while root != None:
                stack.append(root)
                root = root.left

            #we know now root is null
            root = stack.pop()
            count += 1
            if count == k:
                return root.val
            
            #go to the right of current elem
            root = root.right

