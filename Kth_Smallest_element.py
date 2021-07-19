"""Time Complexity : O(n)
 Space Complexity : O(n) 
 Did this code successfully run on Leetcode : yes
 Any problem you faced while coding this :  No

 Your code here along with comments explaining your approach """


 # Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def helper(self, root: TreeNode, arr:list[ int]): #finds inorder of the tree 
        if root == None:
            return 
        self.helper(root.left,arr)
        arr.append(root.val)
        self.helper(root.right,arr)
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        arr = []
        self.helper(root, arr)
        return arr[k-1]
        
        
        