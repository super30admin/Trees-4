#Time COmpelxity : O(N) where N is  number of roots
# Sapce Complexity : O(N) where N is the number of elements stored in stacks

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        st = []
        st.append(root)
        while (len(st)!=0):
            while(root!=None):
                st.append(root)
                root = root.left
            root = st.pop()
            k-=1
            if k == 0:
                return root.val
            root = root.right
        return 