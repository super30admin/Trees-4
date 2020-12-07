# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def __init__(self):
        self.ans = None
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        

        def helper(node):
            if node:
                left = helper(node.left)
                right = helper(node.right)
                mid = node == p or q == node
                if left+mid+right>=2:
                    self.ans = node
                return left or right or mid
            else:
                return False
        helper(root)
        return self.ans
    
    
    Timr: O(N)
    Space: (O(N)- Worst Case)
