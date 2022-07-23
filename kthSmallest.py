# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# TC/Sc: O(N)/O(N)

class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        
        res = []
        def inOrder(node):
            if not node:
                return
            if node.left:
                inOrder(node.left)
            res.append(node.val)
            if node.right:
                inOrder(node.right)
        inOrder(root)
                
        return res[k-1]
        
