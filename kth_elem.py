# // Time Complexity :O(k) 
# // Space Complexity :O(h),height of stack
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        st=[]
        st.append(root)
        while st :
            while root is not None:
                st.append(root)
                root=root.left
            root=st.pop()
            k-=1
            if k==0:
                return root.val
            root=root.right
        return -1
        
            
            
            
        
        