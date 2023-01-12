"""
FAANMG Problem #102 {Medium} 

230. Kth Smallest Element in a BST

Time Complexity O(N)
Space Complexity:  O(H)
        N: nodes of the tree
Did this code successfully run on Leetcode : Yes

Recursive Inorder Solution

@name: Rahul Govindkumar_RN27JUL2022
"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def inorder(self,root):
        
        #logic
        
        # if not root, then return to the previously called function
        if root is None:
            return
        
        #action
        
        # call the root.left
        if not self.flag:
            self.inorder(root.left)
        
        
        # decrement the count which was k
        self.count -=1
        
        # check if k ==0, if so, then put res as root.val
        if self.count == 0:
            self.flag = True
            self.res =  root.val
            return
        
         # check for root.right
        if not self.flag:
            self.inorder(root.right)
        
        
        
        
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        
        
        self.count = k
        self.res=None
        self.flag = False
        
        if not root:
            return self.res
        
        # call the helper function recursively
        self.inorder(root)
        
        return self.res

"""
FAANMG Problem #102 {Medium} 

230. Kth Smallest Element in a BST

    
# Time complexity : O(H)
# Space complexity : O(H)


Did this code successfully run on Leetcode : Yes

Iterative Solution

@name: Rahul Govindkumar_RN27JUL2022
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
  
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        
        
        count = 0
        
     
        stack=[]
        curr = root
        
        
        while True:
            
            while curr:
                stack.append(curr)
                curr = curr.left
                
            curr = stack.pop()
            count +=1
            
            if count==k:
                return curr.val
            
            curr = curr.right
            
                

