# Time Complexity : O(k), where k is the input parameter
# Space Complexity : O(h), where h is the height of the BST


# Definition for a binary tree node.
class TreeNode:
     def __init__(self, val=0, left=None, right=None):
         self.val = val
         self.left = left
         self.right = right
class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        stack = []
        curr = root
        
        while True:
            while curr:
                stack.append(curr)
                curr = curr.left
            
            curr = stack.pop()
            k -= 1
            
            if k == 0:
                return curr.val
            
            curr = curr.right