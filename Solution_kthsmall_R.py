"""
TC = O(log N)

"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution_kthsmall_R:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        if root is None:
            return -1
        self.count=k
        self.result=-1
        self.inorder(root)
        return self.result
    
    def inorder(self,root):
        if(root is None):
            return 
        
        #logic
        self.inorder(root.left)
        self.count-=1
        if(self.count==0):
            self.result=root.val
            return 
        self.inorder(root.right)
    