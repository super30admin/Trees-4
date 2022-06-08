#Time Complexity : O(N)
#Space Complexity : O(N)
#Did this code successfully run on Leetcode : YES
#Any problem you faced while coding this : NO

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        queue = [root]
        while queue:
            node = queue.pop(0)
            if node.val > p.val and node.val > q.val:
                queue.append(node.left)
            elif node.val < p.val and node.val < q.val:
                queue.append(node.right)
            else:
                return node
    
#Recursive
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        rootval = root.val
        pval = p.val
        qval = q.val
        
        if pval > rootval and qval > rootval:
            return self.lowestCommonAncestor(root.right,p,q)
        elif pval < rootval and qval < rootval:
            return self.lowestCommonAncestor(root.left,p,q)
        else:
            return root
    