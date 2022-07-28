'''
Time Complexity: O(n)
Space Complexity: O(h) where h is the height of the tree
Run on Leetcode: YES
'''

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def lowestCommonAncestor(self, root: TreeNode, p: TreeNode, q: TreeNode) -> TreeNode:
        if root == None or root == p or root == q:
            return root
        
        left = self.lowestCommonAncestor(root.left, p , q)
        right = self.lowestCommonAncestor(root.right, p , q)
        
        if not (left or right):
            return None
        if left ==  None and right:
            return right
        if right == None and left:
            return left
        return root