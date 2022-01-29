# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        
#         self.final = []
#         def inorder(root):
#             if root is None:
#                 return
            
#             inorder(root.left)
#             self.final.append(root.val)
#             inorder(root.right)
#             return
#         inorder(root)
#         # print(self.final)
#         return self.final[k-1]

        """
        Time complexity : O(H+k)
        Space complexity : O(H)
        Kth Smallest Element in a BST

        """
        stack = []
        
        while True:
            while root:
                stack.append(root)
                root = root.left
            root = stack.pop()
            k -= 1
            if k:
                root = root.right
            else:
                return root.val