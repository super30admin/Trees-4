# Time Complexity : O(N) whenre N is number of Nodes in the tree
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        stack = []

        while root != None or len(stack) != 0:
            while root != None:
                stack.append(root)
                root = root.left
                
            root = stack.pop()
            k -= 1
            if k == 0:
                return root.val
            
            root = root.right
            
        return -1