# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

'''
Solution : DFS (InOrder Traversal gives ascending order). 
    - Keep a global count variable. 
    - increase the count after left subtree is processed. In-Order fashion
    - if the count equals 'k', return this node's value. 
Time Complexity: O(k)
Space Complexity: O(h), h = height of tree, recursive stack.
'''

class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.count = 0
        return self.helper(root,k)
    
    def helper(self,node,k):
        # base
        if node==None:
            return -1

        left = self.helper(node.left,k)
        if left!=-1: # already found, don't go further
            return left
        
        self.count+=1 # in-order, increase the count
        if self.count==k:
            return node.val
        
        right = self.helper(node.right,k)

        return right # return whatever we found on right sub-tree  
        