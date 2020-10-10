# // Time Complexity : O(n), n is the no. of elements
# // Space Complexity : O(maxdepth)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

# // Your code here along with comments explaining your approach: 
# We need to find a relation between elements and start with examples to figure out the algorithm to solve this. 
# Starting with the postorder approach-> need to recurse on left then right and root
#Intuition: Return boolean value for the left and right branches, if true is returned from both sides that means we are at the LCA
# However, we aren't returning the value so how will we find our answer? To curb this problem, we can return the element as a node when its true(or the value was there in the branch) and null if its false. 

#below approach uses preorder

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        if root == None:
            return None
        
        #proess root
        if p.val==root.val or q.val == root.val:
            return root
        
        #process left branch
        left = self.lowestCommonAncestor(root.left, p, q)
        
        #process right branch
        right = self.lowestCommonAncestor(root.right, p, q)
        
        if left != None and right != None:
            return root
        elif left != None and right == None:
            return left
        else:
            return right
        
        
        