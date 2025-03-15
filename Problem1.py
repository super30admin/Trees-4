# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#time complexity o(n)
#space complexity o(h)
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        st = []

        while root or st:
            #inorder root.left
            while root != None:
                st.append(root)
                root = root.left
            
            root = st.pop()
            k -= 1
            if k == 0:
                return root.val
            
            root = root.right
        
        return 234

