#Time COmplexity:O(H)
#Space Complexity:O(H)

#Approach:Since the left subtree has the smallest element of a tree, we parse through all the left subtree element. Every time we pop and element from stack we decrement k if k is >0
#we continue searchinmg other braches of tree. If k reached zero we return the value of the poped node.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        st=[]
        while st or root:
            while root:
                st.append(root)
                root=root.left
            root=st.pop()
            k-=1
            if k==0:
                return root.val
            root=root.right
        return -1