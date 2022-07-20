""""// Time Complexity : O(n)
// Space Complexity : O(h) Recursive Stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""


# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.res = 0
        self.count = k
        self.helper(root)
        return self.result

    def helper(self, root):

        if root == None:
            return

        self.helper(root.left)

        self.count -= 1
        if (self.count == 0):
            self.result = root.val
            return

        self.helper(root.right)

# class Solution:
#     def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
#         self.count = k
#         return self.helper(root)


#     def helper(self,root):

#         if root==None:
#             return float('inf')

#         left= self.helper(root.left)

#         if left!=float('inf'):
#             return left
#         self.count-=1
#         if(self.count==0):
#             return root.val


#         return self.helper(root.right)
