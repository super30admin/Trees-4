# // Time Complexity : inorder -o(n)
# // Space Complexity : o(n)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : understading the pattern


# // Your code here along with comments explaining your approach
# naive idea is find inorder traversal and return the kth smallest

from typing import Optional
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
# class Solution:
#     def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
#         self.result = 0
#         self.count = k
#         def helper(root):
#             if not root : return
#             helper(root.left)
#             self.count-=1
#             if self.count == 0:
#                 self.result = root.val
#                 return
#             helper(root.right)
#         helper(root)
#         return self.result

# class Solution:
#     def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
#         self.result = float("inf")
#         self.count = k
#         def helper(root):
#             if not root : return
#             if self.result!=float("inf"): return
#             helper(root.left)
#             self.count-=1
#             if self.count == 0:
#                 self.result = root.val
#             helper(root.right)
#         helper(root)
#         return self.result

# class Solution:
#     def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
#         self.result = float("inf")
#         self.count = k
#         def helper(root):
#             if not root : return float("inf")
            
#             left = helper(root.left)
#             self.count-=1
#             if self.count == 0:
#                 return root.val
#             right = helper(root.right)
#             if left!= float("inf") : return left
#             if right!= float("inf"): return right
#             return float("inf")
            
#         return helper(root)

class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.result = float("inf")
        self.count = k
        def helper(root):
            if not root : return float("inf")
            
            left = helper(root.left)
            self.count-=1
            if self.count == 0:
                return root.val
            right = helper(root.right)
            # if left!= float("inf") : return left
            # if right!= float("inf"): return right
            return min(left,right)
            
        return helper(root)