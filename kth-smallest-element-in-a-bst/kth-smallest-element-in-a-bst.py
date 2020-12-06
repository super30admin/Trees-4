#Time: O(N)
#Spce: O(N)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        
        def inorder(root):
            if root:
                inorder(root.left)
                temp.append(root.val)
                inorder(root.right)
        
        temp = []
        inorder(root)
        return temp[k-1]
