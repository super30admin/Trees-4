# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:

            # Method 1 - Recursive - do inorder and reduce count by 1 each time and the moment count is 0, return root at that point
            #TC and SC - O(n)
            count=k
            res=None
            if not root: return 0

            def inorder(root):
                nonlocal count,res
                #base
                if not root: return

                #logic
                if count>0: #only if count>0 iterate
                    inorder(root.left)
                count-=1
                if count==0:
                    res=root
                if count>0:  #only if count>0 iterate
                    inorder(root.right)

            inorder(root)
            return res.val


