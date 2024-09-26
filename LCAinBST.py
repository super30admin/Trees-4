#time complexity: O(n)
#leetcode:accepted
#explination: we know that in a bst, all the elements in the left are smaller and all the elements in the right side are greater. using this property of the binary search tree, we compare the values of p and q with the values of the root. if both the values are smaller than the root then we know that the elemetns lie in the left subtree so we  traverse in the left direction. If both the values of p snd q are greater,we traverse through the right side, else just return root(when one is smallr and other is greater)



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root ==None:
            return None
        if p.val < root.val and q.val< root.val:
            return self.lowestCommonAncestor(root.left,p,q)
        elif p.val > root.val and q.val > root.val:
            return self.lowestCommonAncestor(root.right,p,q)
        else:
            return root