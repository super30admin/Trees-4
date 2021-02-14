# -*- coding: utf-8 -*-
"""
time Complexity : O(N) where N is the number of nodes in the tree
Space Complexity : Recursive stack used O(N)
"""
'''
We use iterative inorder traversal that requires a single stack. 
We iterate until our stack is empty or our root value is None which will happen 
when we have iterated over our entire tree. 
Inside the while loop we have another loop that is used to reach the left most child from a root. 
Once we are at the left most child, from the binary search tree property, 
we know that it is the smallest one in that subtree with respect to our current root so we can safely decrement the 'k'.
We now check if our k is equal to 0. 
If yes, then we have found our element and we return its value other wise we make our new root the 
right of the popped node and we repeat the same procedure. 
The speed comes from the iterative nature of the traversal where we are doing in time processing and 
can easily break out when we have found our desired element.
'''
class TreeNode:
     def __init__(self, val=0, left=None, right=None):
         self.val = val
         self.left = left
         self.right = right
         
class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        stack = [] 
        while len(stack) or root:
            while root:
                stack.append(root)
                root = root.left
            
            elem = stack.pop()
            k -= 1
            if k == 0:
                return elem.val
            root = elem.right

S = Solution()

k = 3
print(S.kthSmallest([5,3,6,2,4,None,None,1],k))