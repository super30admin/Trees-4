# // Time Complexity : O(logn), amortized O(n) since the tree can be skewed
# // Space Complexity : worst case->O(n) 
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

# // Your code here along with comments explaining your approach: 



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
        
        #p<root and q<root
        if p.val < root.val and q.val < root.val:
            return self.lowestCommonAncestor(root.left, p, q)
        
        #q>root and p>root
        elif p.val > root.val and q.val > root.val:
            return self.lowestCommonAncestor(root.right, p, q)
        
        #we are at the point where the answers are at different branches and hence that's our LCA
        else:
            return root