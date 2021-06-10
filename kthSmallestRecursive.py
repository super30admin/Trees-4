# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.result = 0
        self.count = 0
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        
        self.helper(root, k)
        return self.result
    
    def helper(self, root, k):
        if root is None:
            return
        
        self.helper(root.left,k)
        #st.pop()
        self.count +=1
        if self.count == k:
            self.result = root.val
        self.helper(root.right, k)
