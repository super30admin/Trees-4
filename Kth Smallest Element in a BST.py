# Time Complexity :
# TC: O(N) --> Traversing the whole tree
    
# Space Complexity :
# SC: O(H) --> Size of stack --> Height of tree

# Did this code successfully run on Leetcode :
# Yes

# Any problem you faced while coding this :
# No

# Your code here along with comments explaining your approach

# Iterative Inorder Traversal --> Controlled Recursion
# Stoping recursion when Kth element is popped from stack

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    # Iterative Inorder Traversal --> Controlled Recursion
    # Stoping recursion when Kth element is popped from stack
    # TC: O(N) --> Traversing the whole tree
    # SC: O(H) --> Size of stack --> Height of tree
    
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        
        stack = []
        
        while(True): 
            while (root):
                stack.append(root)
                root = root.left
            root = stack.pop()
            
            k -= 1
            if (not k):
                return root.val
            
            root = root.right