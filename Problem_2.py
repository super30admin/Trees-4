# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on leetcode : Yes
# Any problem you faced while coding this : No 

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        x=max(p.val,q.val)
        y=min(p.val,q.val)
        def lca(temp,x,y):
            if (temp.val<=x and temp.val>=y):
                return temp
            elif temp.val>x and temp.val>y:
                return lca(temp.left,x,y)
            else: 
                return lca(temp.right,x,y)
        return lca(root,x,y)