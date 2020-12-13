# Time:- O(k)
# Space:- O(h) h=height of the tree
# Approach:- While doing an inorder traversal of the tree mark what is the current index in the inorder traversal,
# if the current index is equal to the index we are looking for we give out the answer
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        self.i=1
        self.found=False
        def inorder(root):
            if root is None or self.found:
                return
            inorder(root.left)
            if self.i==k and not self.found:
                self.res=root.val
                self.found=True
                return
            self.i+=1
            inorder(root.right)
        inorder(root)
        return self.res
        
            