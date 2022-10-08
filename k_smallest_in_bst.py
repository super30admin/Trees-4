# // Time Complexity : O(n)
# // Space Complexity : O(h)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Nope


# // Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

############Iterative Solution ###############
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        n=0
        stack=[]
        curr=root

        #Until we reach the end or the stack is non empty
        while curr or stack:
            #whle we reach the leaf
            while curr:
                #Add the elemtns to the stack
                stack.append(curr)
                #Move to the left
                curr=curr.left
            
            #When we reach the leaf remove the top of the stack
            curr=stack.pop()
            #increase the n
            n+=1

            #When n==k return the curr value
            if n==k:
                return curr.val

            #Move to the right
            curr=curr.right