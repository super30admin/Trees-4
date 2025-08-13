# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
    #     self.k = k
    #     # self.result
    #     return self.helper(root)
       
    # def helper(self,root):
        
    #     if root is None:
    #         return  0
        
    #     left = self.helper(root.left)
    #     self.k = self.k - 1
    #     if self.k == 0: #k=
    #         return root.val
    #     right = self.helper(root.right)    

    #     return left if left !=0 else right

    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.result = -1
        self.count = k
        self.recurse(root)
        return self.result

    def recurse(self, root):
        if not root or self.result != -1:
            return
        
        self.recurse(root.left)
        self.count -= 1
        if self.count == 0:
            self.result = root.val
        self.recurse(root.right)


        

