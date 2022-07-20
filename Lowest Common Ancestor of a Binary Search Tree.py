# time complexity is o(h), where h = log(n), where n is the size of the input tree
# space complexity is o(h), where h = log(n), where n is the size of the input tree(Recursive stack space)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # res = 0
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        if(root.val > p.val and root.val > q.val):
            return self.lowestCommonAncestor(root.left, p,q)
        if(root.val < p.val and root.val < q.val):
            return self.lowestCommonAncestor(root.right, p,q)
        else:
            return root
        
                
            