
# Time Complexity : O(n) (We have to pass throught every element of tree.)
# Space Complexity : O(1) (We are not storing any additional information. Also helper function is calling recusrion. )
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english:
# - Inorder traversal of binary search tree gives number in sorted form.
# - So first do inorder traversal of tree and than return kth element from the list to find kth minimum element.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def __init__(self):
#       Initializing global variable to store inorder traversal
        self.data = []
        
    def kthSmallest(self, root: TreeNode, k: int) -> int:
#       Call helper function on root
        self.helper(root, 0, k)
#       returning kth element from the list.
        return self.data[k-1]
        
    def helper(self, root, index, k):
#       Chechking if root is available or not
        if root:
#           Passing left node in the helper function
            self.helper(root.left, index, k)
#           Appending current value to the data.
            self.data.append(root.val)
#           Passing right node in the helper function
            self.helper(root.right, index, k)
            
        
        
