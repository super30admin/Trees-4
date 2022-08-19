# Time complexity: O(n)
# Space complexity: O(h)
# Approach: the logic used is inorder traversal of the BST(which gives the sorted order)
# but reach the last left most node of the tree and start a counter of k
# and do inorder traversal-left, node and right
# when the counter becomes k or 0(up or down counter), return the value of node


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.result = -1
        self.count=0
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.count = k
        self.inorder(root)
        return self.result
    def inorder(self, root):
        #base
        if root == None:
            return
        
        #recursion
        self.inorder(root.left)
        self.count -= 1
        if self.count == 0:
            self.result = root.val
            return
        self.inorder(root.right)
        
        