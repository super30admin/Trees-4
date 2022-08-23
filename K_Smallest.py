# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        l=[0]
        curr=0
        def inorder(root):
            nonlocal curr
            if root is None:
                return
            
            inorder(root.left)
            curr+=1
            if curr==k:
                l[0]=root.val
            inorder(root.right)
            
        inorder(root)
        
        return l[0]
                
        