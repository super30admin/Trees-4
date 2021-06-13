"""Time Complexity : O(N)
Space Complexity: O(n)"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        #iterative solution -> inorder traversal
        stack = []
        count = 0 
    
        
        while root or stack:
            while root:
                #add root to stack
                stack.append(root)
                root =root.left
            root = stack.pop()
            count +=1
            if count ==k:
                return root.val
            root = root.right
        return -1
            
        