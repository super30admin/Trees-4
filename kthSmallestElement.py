'''
Tc - O(N)
SC - O(N)
Algorithm - 

Inorder traversal Left Root Right
1) Going to the leftmost element unless we hit the Null node which will be the smallest element in BST 
2) Decrement count. Check if count ==0, that value of root will be answer
3) Traverse right element
 
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        
        #base case
        if root == None:
            return root
        
        self.count = k
        self.result=0 # For storing the final result
        self.helper(root)
        
        return self.result
        
    def helper(self,root):
        
        # Inorder traversal to reach the left most element which will be the first smallest element in bst
        
        if root.left:
            self.helper(root.left)
            
        self.count-=1
        if self.count == 0:
            self.result =  root.val
            return
        
        # Right Traversal
        if root.right:
            self.helper(root.right)
            
''' 
    #Brute Force
    # TC - O(N)
    # SC - O(N)

    def kthSmallest(self, root: TreeNode, k: int) -> int:
        
        inorder = []
        result = self.helper(root,inorder)
        
        return result[k-1]
    
    def helper(self,root,inorder):
        
        if root:
            self.helper(root.left,inorder)
            inorder.append(root.val)
            self.helper(root.right,inorder)
            
        return inorder
'''