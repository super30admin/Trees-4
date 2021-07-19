# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        """
        TC:O(n)
        SC:O(h)
        """
        n=0
        stack=[]
        cur=root
        
        while True:
            while cur:
                stack.append(cur)
                cur=cur.left
            cur=stack.pop()
            n+=1
            if n==k:
                return cur.val
            cur=cur.right