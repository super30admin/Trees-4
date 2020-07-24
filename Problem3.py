# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


"""

        Name : Shahreen Shahjahan Psyche
        Time : O(N) [Where N repreesents the number of Nodes]
        Space: O(H) [Recursive Stack Space]
        
        Passed Test Cases in LC : Yes


"""

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        # edge case
        if not root or p.val == root.val or  q.val == root.val:
            return root
        
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)
        
        
        # if my left is not empty but right is still empty then I am returning the left Node
        if left is not None and right is None:
            return left
        # if my right is not empty but left is still empty then I am returning the right Node
        elif right is not None and left is None:
            return right
        # But, if my both left and right are not empty, that means I have found the LCA
        elif right is not None and left is not None:
            return root
        else:
            return
