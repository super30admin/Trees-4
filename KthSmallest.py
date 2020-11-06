# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    result=0
    count = 0
    
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        
        self.count = k
        
    
    
        def helper(node):
            #nonlocal count, k, result
            if node.left!=None:
                helper(node.left)

            self.count-=1

            if self.count==0:
                self.result=node.val
                return

            if node.right!=None:
                helper(node.right)
                
                
        helper(root)
        return self.result
            
        # Time Complexity : O(N)
        # Space Complexity: O(N) #Implicit Stack for recursion
                
                
        
        
        
        