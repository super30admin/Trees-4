# Time Complexity : O(LogN) WHERE N is number of roots
#Space Complexity : O(K) where K is height of tree
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root.val > p.val and root.val >q.val:
            return self.lowestCommonAncestor(root.left,p,q)
        elif root.val < p.val and root.val < q.val:
            return self.lowestCommonAncestor(root.right,p,q)
        else:
            return root
===================================================================
# Time Complexity : O(N) WHERE N is number of roots
#Space Complexity : O(1) 
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        while(root!=None):
            if root.val > p.val and root.val >q.val:
                root =root.left
            elif root.val < p.val and root.val < q.val:
                root = root.right
            else:
                return root
        
        