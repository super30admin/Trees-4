'''
1. We use inorder traversal as in case of BST we get the elements in increasing order in case of inorder.
2. Maintain a variable to check number of nodes visited.
3. kth visited node is the kth smallest number.

TC: O(n)
SC: O(h)
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        if not root:
            return -1 
        self.ct = k
        self.answer = -1
        self.inorder(root)
        return self.answer


    def inorder(self, root):
        # base case
        if not root:
            return

        self.inorder(root.left)
        self.ct -= 1
        if self.ct == 0:
            self.answer = root.val
            return
        self.inorder(root.right)
