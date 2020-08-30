# APPROACH  1: BRUTE FORCE
# Time Complexity : O(n), n: number of nodes in the tree
# Space Complexity : O(n), space due to list
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Do inorder traversal of tree and store the nodes in a list
# 2. At the end, return the k - 1 th element

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        if root is None:
            return None
        
        tree_list, stack, isFirst = [], [], True
        
        while root is not None or (len(stack) > 0 or isFirst):
            isFirst = False
            while root is not None:
                stack.append(root)
                root = root.left
            
            root = stack.pop()
            tree_list.append(root.val)
            
            root = root.right
            
        return tree_list[k - 1]
        
        
        

# APPROACH 2: OPTIMAL ITERATIVE 
# Time Complexity : O(k), k: given
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Do an inorder traversal of tree and keep count of the nodes popped from stack so far (visited completely)
# 2. Stop when you reach the kth node and return it's value

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        if root is None:
            return None
        
        count, stack, isFirst = 0, [], True
        
        while root is not None or (len(stack) > 0 or isFirst):
            isFirst = False
            while root is not None:
                stack.append(root)
                root = root.left
            
            root = stack.pop()
            count += 1
            
            if count == k:
                break
            
            root = root.right
            
        return root.val
        
        
        
# APPROACH 3: OPTIMAL RECURSIVE 
# Time Complexity : O(n), n: number of nodes
# Space Complexity : 
# Did this code successfully run on Leetcode : 
# Any problem you faced while coding this : 
#
#
# Your code here along with comments explaining your approach
# 1. Same as above approach but in recursive way. 

        
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.count = 0
        self.result = None
        
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        
        if root is None:
            return None
        
        self.inorder(root, k)
        return self.result
    
    
    def inorder(self, root, k):
        if root is None:
            return
        
        self.inorder(root.left, k)
        self.count += 1
        
        if self.count == k:
            self.result = root.val
            return
        
        self.inorder(root.right, k)
                
