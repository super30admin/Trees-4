# // Time Complexity : O(n)
# // Space Complexity : O(maxdepth), stack only requires maxdepth
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

# // Your code here along with comments explaining your approach: 
# Approach #1: Do in order traversal and iterate through the list in O(n) time with O(n) space
# Approach #2: Recursive approach
# Approach #3: Iterative approach- maintain a stack, while root is not none, push all elements of left side on the stack. When root is none, pop one out from the stack and assign the root as popped.right and keep adding to output list. Iterate till kth element to find the output. Time O(n), space O(n)
#Approach #4, coded below: maintain count and a variable popped. As soon as count==k, return popped. Time O(n), space O(maxdepth) (Not that big of an improvement)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        if root == None:
            return -1
        
        stack = []
        cnt = 0
        
        while stack or root != None:
            
            while root != None:
                stack.append(root)
                root = root.left
            
            popped = stack.pop()
            cnt += 1
            if cnt ==k:
                return popped.val
            
            root = popped.right
            
        return -1
            

# Approach #5: Morris Tree traversal with space O(1) 
