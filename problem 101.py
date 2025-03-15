# https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.count = k
        self.inorder(root)        
        return self.res
    
    def inorder(self,root):
        if root == None:
            return
        
        self.inorder(root.left)
        self.count-=1
        if (self.count == 0):
            self.res = root.val
        self.inorder(root.right)


# TC: O(n)
# SC: O(h)


###################### Iterative inorder appraoch ######################

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        st = []
        while st or root:
            while root:
                st.append(root)
                root = root.left
            
            root = st.pop()
            k-=1
            if k==0:
                res = root.val
            root = root.right
        
        return res

# TC: O(n)
# SC: o(h) no extra recursive space

