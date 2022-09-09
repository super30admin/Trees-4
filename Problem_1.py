"""
Did this code successfully run on Leetcode :
Any problem you faced while coding this :


Your code here along with comments explaining your approach

Problem1 Kth Smallest Element in a BST 
(https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/)
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        """
        Time Complexity : O(N) N: no of treeNodes
        Space Complexity :O(N)
        Using inorder traversal and storing the TreeNode vals in an array.
        Iterating till k-1 to get the kth element
        
        """
        count = k
        self.res = []
        self.flag = False
        def inorder(root):
            # Base Condition
            if root == None: return 
            if len(self.res) == count:
                self.flag = True
                return self.res
           
            # Logic
            if not self.flag:
                inorder(root.left)
                self.res.append(root.val)
                inorder(root.right)
        
        inorder(root)
        return self.res[k-1]
        
        
        
# Approach - 2
     
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        """
        Using stack and performing inorder traversal
        Time Complexity : O(H) H: height of the tree
        Space Complexity :O(H)
        """
        stack = []
       
        while True:
            while root:
                stack.append(root)
                root = root.left
                
            curr = stack.pop()
            k -= 1
            if k == 0:
                return curr.val
            
            root = curr.right
                
