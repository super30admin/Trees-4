"""
// Time Complexity : O(n) //number of elements
// Space Complexity : O(n) //stackspace
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
Algorithm Explanation
- Restrictive iterative inorder till we get kth element from the popped 
root from the stack
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        stack = []
        count = 0
        while stack or root:
            #iterate to the end of left subtree
            while root:
                stack.append(root)
                root = root.left
            #get the current root
            root = stack.pop()
            k-=1
            if k == 0:
                return root.val
            #move to right and repeate the process
            root = root.right
            
        return -1