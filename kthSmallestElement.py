"""
Recursive approach
TC - O(h) + O(k) ==> O(h) because if the tree is right skwed or left skwed, the height of the tree elements get processed
SC - O(h) ==> height of the tree
"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        if not root: return -1

        self.rtnData = -1
        self.count = 0

        def inorder(root, k):
            # base case
            if not root: return

            # logic
            # root = 5 rtnData = -1 count = 0
            # root = 3 rtnData = -1 count = 0
            # root = 2 rtnData = -1 count = 0
            # root = 1 rtnData = -1 count = 0
            if self.rtnData == -1:
                # inorder(3, 3)
                # inorder(2, 3)
                # inorder(1, 3)
                # no left node for 1 ==> count = 1, therefore return to 2.
                # no right node for 2 ==> count = 2, therefore return to 3.
                # right node is present for 3 ==> count = 3
                inorder(root.left, k)
                self.count += 1
            # count 3 == k (3)
            if self.count == k:
                # return 3
                self.rtnData = root.val
                # since k is reached, we just return, no need to process right node of 3
                return
            inorder(root.right, k)

        inorder(root, k)

        return self.rtnData
