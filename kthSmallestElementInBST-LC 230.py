# Inorder Traversal using count or k variable
# Time Complexity = O(n)
# Space Complexity = O(h), recursive stack


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        if root == None or k == 0:
            return -1
        
        self.count = k
        self.result = -1
        
        self.inorder(root)
        
        return self.result
    
    
    def inorder(self, root):
        # Base Case
        if root == None:
            return
        
        # Logic
        
        # Only do left traversal if self.result == -1
        # So if we found our result root, the traversal will not keep going on till the last root node
        if self.result == -1:
            self.inorder(root.left)
            self.count -= 1
        
        if self.count == 0:
            self.result = root.val
            return
        
        if self.result == -1:
            self.inorder(root.right)

            
# Iterative Solution
# Time complexity = O(n)
# Space Complexity = O(h)


class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        if root == None or k == 0:
            return -1
        
        stack = []
        s =[]
        stack.append(root)
        
        while(stack or root != None):
            while(root != None):
                stack.append(root)
                s.append(root.val)
                root = root.left            # First we'll go as left as possible
                
            root = stack.pop()
            k -= 1
            
            if k == 0:
                return root.val
            
            root = root.right
                
        
        return -1
    
    
        