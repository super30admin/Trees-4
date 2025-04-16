'''
    Time Complexity: O(logk)
    Space Complexity: O(k)
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.inorder = []
        self.count = 0

    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.helper(root, k)
        return self.inorder[k-1]
        
    def helper(self, root, k):
        # base case
        if not root:
            return

        # logic
        self.helper(root.left, k)
        self.inorder.append(root.val)
        self.count += 1

        if self.count < k:
            self.helper(root.right, k)