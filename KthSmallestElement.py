#// Time Complexity : O(n) 
# // Space Complexity : O(n) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : No.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        arr = []
        if not root:
            return
        def inorder(root):
            nonlocal arr
            if A == None:
                return 
            if root.left:
                inorder(root.left)
            arr.append(root.val)
            if root.right:
                inorder(root.right)
        
        inorder(root)
        return arr[k-1]

# Approach:
# The problem asks us to find the kth smallest element in a binary search tree. We can solve
# this problem by performing an in-order traversal of the binary search tree and storing the
# elements in an array. The kth smallest element will be the kth element in the array.
# In this solution, we define a helper function inorder() that performs an in-order traversal of the
# binary search tree. We use a nonlocal variable arr to store the elements in the array. We
# append the value of each node to the array as we visit it. Finally, we return the k
# element of the array.
        