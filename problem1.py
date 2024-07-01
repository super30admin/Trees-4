#Time Complexity : O(n) - visit all the nodes
#Space Complexity : O(h) - O(n) for skewed and O(logn) for the best case scenario
#Any problem you faced while coding this : -

#The approach is to maintain global variables for the storing kth smallest node and a counter. The idea is to perform inorder traversal and after every left recurisve call we decrement the count and check if its zero, as this means we have reached the kth smallest element.  

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.result = None
        self.count = 0

    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.count = k
        self.inorder(root)
        return self.result.val

    def inorder(self, root):
        if root is None:
            return

        self.inorder(root.left)
        self.count -= 1
        if self.count == 0:
            self.result = root

        self.inorder(root.right)
