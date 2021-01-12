# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


"""
Approach 1:

In this approach we will traverse through the tree in an inorder fashion storing all the elements a list. As the tree is BST the elements that will be stored will be in an ascending order. So now we will just return the (k-1)th element from the list
TC: O(n)
SC: O(n)

n = no of nodes
"""
# class Solution:
#     def kthSmallest(self, root: TreeNode, k: int) -> int:
#         if root == None:
#             return 0
#         self.ls = []

#         self.helper(root)
#         return self.ls[k-1]
        
#     def helper(self,root):
#         if root == None:
#             return  
        
#         self.helper(root.left)
#         self.ls.append(root.val)
#         self.helper(root.right)
        
"""
Approach 2: Recursive

In the previous approach we were traversing entire tree and storing it. Here instead of traversing entrire tree we just maintain the count. If the count reaches k then we have found our element and we need to return it. 

TC: O(h+k)
SC: O(h)
h = height of the tree
"""
class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        self.result = None
        if root == None:
            return 0
        
        self.count = 0
        
        self.helper(root,k)
        return self.result   
    
    def helper(self,root,k):
        if root == None or self.result != None:
            return
        
        self.helper(root.left,k)
        
        self.count += 1
        if self.count == k:
            self.result = root.val
            return
        self.helper(root.right,k)
        
"""
Approach 2: Iterative 

Iterative apporach to previous apporach
TC: O(h+k)
SC: O(h)
h = height of the tree
"""
class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        if root == None:
            return 0
        
        stack = []
        
        while root != None or len(stack):
            
            # Go as far left as possible
            while root != None:
                stack.append(root)
                root = root.left
                
            root = stack.pop()
            k -= 1
            if k == 0:
                return root.val
            
            root = root.right
            
        return -1
        