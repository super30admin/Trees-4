# Problem 1 : Kth Smallest Element in a BST
# Time Complexity :
'''
Recursion - O(n) where n is the number of nodes in a tree
int based recursion - O(n) where n is the number of nodes in a tree
iterative - O(n) where n is the number of nodes in a tree
'''
# Space Complexity :
'''
Recursion - O(n) where n is the number of nodes in a tree
int based recursion - O(n) where n is the number of nodes in a tree
iterative - O(n) where n is the number of nodes in a tree
'''
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach
# Recursion

# Definition for a binary tree node.
from typing import Optional
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        # edge case where root is None
        if root == None:
            return None
        # define the count variable for counting the lowest elements in the tree
        count = 0
        # define the result which will initially have root value
        result = root.val

        # inorder function used for doing inorder traversal
        # this is void function
        def inorderTraversal(root: Optional[TreeNode], k: int) -> None:
            # count and result are global variable
            nonlocal count, result
            # base case if the root is None then return
            if root == None:
                return
            
            # traverse the left of the root
            inorderTraversal(root.left, k)
            # increment the count while processing the root
            count += 1
            # check if count equal to k 
            if (count == k):
                # if it is equal means we got the kth lowest element
                # set the result with the value and return 
                result = root.val
                return
            # traverse the right of the root
            inorderTraversal(root.right, k)

        # do inorder traversal on the root
        inorderTraversal(root, k)
        return result

# int based recursion


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        # edge case where root is None
        if root == None:
            return None
        # define the count variable for counting the lowest elements in the tree
        count = 0

        # inorder function used for doing inorder traversal
        # this is int based recursion
        def inorderTraversal( root: Optional[TreeNode], k: int) -> int:
            # count is global variable
            nonlocal count
            # base case if the root is None then return
            if root == None:
                return None
            
            # traverse the left of the root
            # return value will be the kth lowest value if it lies in the left part of the tree
            element = inorderTraversal(root.left, k)
            # check if the element is not None ie we got the kth lowest element then simply return that value 
            if element != None:
                return element

            # increment the count variable
            count += 1
            # check if count equal to k 
            if count == k:
                # if it is equal means we got the kth lowest element
                # set the result with the value and return
                return root.val
            
            # traverse the right of the root
            # return value will be the kth lowest value if it lies in the right part of the tree
            element = inorderTraversal(root.right, k)
            # check if the element is not None ie we got the kth lowest element then simply return that value 
            if element != None:
                return element
            
        # get the kth lowest value for tree and return that value
        element = inorderTraversal(root, k)
        return element


# Iterative Approach
# Definition for a binary tree node.
from typing import Optional
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        # edge case where root is None
        if root == None:
            return None
        # define the count variable for counting the lowest elements in the tree
        count = 0
        # define stack which will store the node while traversing the tree
        stack = []
        # set the current to root
        current = root
        # loop till the stack is not empty and current is not None
        while stack or current:
            # if current is not None
            if current:
                # append the current to stack
                stack.append(current)
                # move to left part by setting the current to current.left
                current = current.left
            # if current is None ie means there is no left part
            else:
                # pop the element from the stack and processed the element
                popedElement = stack.pop()
                # increment the count variable
                count += 1
                 # check if count equal to k 
                if count == k:
                    # if it is equal means we got the kth lowest element
                    # set the result with the value and return
                    return popedElement.val
                # set the current to poped element.right ie traverse the right part of the node
                current = popedElement.right
        # if not found then return -1
        return -1

        
        