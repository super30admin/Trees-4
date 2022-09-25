# Time Complexity : O(H) or O(log N) whenre H is height of the BST and N is number of Nodes in the tree
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

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
        
        return self.findLCA(root, p, q)
        
        
    def findLCA(self, root, p, q):
        if root == p or root == q or root == None:
            return root
        
        left = self.findLCA(root.left, p, q)
        right = self.findLCA(root.right, p, q)
        
        if left and right:
            return root
        elif left != None and right == None:
            return left
        elif right != None and left == None:
            return right
        else:
            return None