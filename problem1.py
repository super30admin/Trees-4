# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        def InOrder(node):
            if node:
                InOrder(node.left)
                self.k-=1
                if self.k==0:
                    self.final=node.val
                    return
                InOrder(node.right)    
        self.final=None
        self.k=k
        InOrder(root)   
        return self.final
        #Time O(n)
        #Space O(n)
