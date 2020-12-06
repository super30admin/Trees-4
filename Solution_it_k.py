"""
Time complexity O(H+k)
Space in stack is O(H)

"""



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        st=[]
        while(root or st):
            while(root):
                st.append(root)
                root=root.left
            root=st.pop()
            k-=1
            if(k==0):
                return root.val
            root=root.right
        return -1
        