'''

Time Complexity : O(k)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No issues faced

Your code here along with comments explaining your approach

Recursively find the kth element by traversing the tree inorderly

'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        def kth(root,k,n):
            if root is None:
                return

            kth(root.left,k,n)

            self.count += 1
            if self.count == k:
                self.res = root.val

            kth(root.right,k,n)

        self.count = 0
        self.res = 0
        kth(root,k,[0])
        return self.res






