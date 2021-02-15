# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    
    """
    Description: Given root of a BST, and integer k, return the kth smallest element in the tree
    
    Time complexity: O(n)
    Space complexity: O(h)
    
    Approach:
    - keep a stack and append values going left first, followed by going right (2 while loops)
    - reduce value of k until it reach 0, and then return the value of the current root
      (kth smallest since)
    """
    
    def kthSmallest(self, root: TreeNode, k: int) -> int:
               
        stack = []
        
        while len(stack) != 0 or root != None:
            
            # go left
            while root != None:
                stack.append(root)
                root = root.left
            
            temp = stack.pop()
            # reduce value of k 
            k -= 1
            if k == 0: return temp.val
            
            # go right
            root = temp.right
