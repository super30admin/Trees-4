 # Time Complexity:  O(n) where n is the number of nodes
 #  Space Complexity:  O(n)
#  Did this code successfully run on Leetcode : Yes
 #  Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def inorder(self, root: Optional[TreeNode], l: List[int]):
        
        if not root:
            return
        
        self.inorder(root.left,l)
        l.append(root.val)
        self.inorder(root.right,l)
        
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        
        if not root:
            return 0
        
        l = []
        self.inorder(root,l)
        return l[k-1]
