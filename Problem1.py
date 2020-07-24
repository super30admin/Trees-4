"""
// Time Complexity : o(n)
// Space Complexity : o(h), stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int: #inorder traversal till k elements
        st = []
        
        while root or st:
            while root: 
                st.append(root)
                root = root.left #reach the last left child from root
                
            root = st.pop()
            
            k -= 1 # as you iterate over the tree, keep reducing k till it becomes 0 and then return root value
            if k == 0:
                return root.val
            
            root = root.right