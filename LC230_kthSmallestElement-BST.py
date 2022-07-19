"""
For kth smallest element, we will do inorder traversal and we can reduce the count every time we find a node. Once k becomes 0, we return the node.
TC = O(n)
SC = O(h)

"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.count = k
        self.element = -1
        self.helper(root)
        return self.element
    
    def helper(self, root):
        if root == None:
            return None
        self.helper(root.left)
        self.count-=1
        if self.count==0:
            self.element = root.val
        self.helper(root.right)
        
        