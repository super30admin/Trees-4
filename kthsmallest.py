"""https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    """
    inorder traversal to build array in ascending order then , 0th element is smallest, 1st element is bigger than 0 so 2nd smallest element = k-1
    """

    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        def inorder(r):
            return inorder(r.left) + [r.val] + inorder(r.right) if r else []

        return inorder(root)[k - 1]


