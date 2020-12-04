#Time Complexity : O(n) where n is number of nodes in the tree
#Space Complexity : O(n) where n is number of nodes in the tree
#Did this code successfully run on Leetcode : Yes

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        inorder = []

        def getInorder(root):
            if root:
                getInorder(root.left)
                inorder.append(root.val)
                getInorder(root.right)

        #get inorder traversal of tree which will be sorted in ascending order
        getInorder(root)

        return inorder[k-1]
