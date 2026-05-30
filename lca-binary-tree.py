# time: O(n)
# space: O(h)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if not root or root == p or root == q:
            return root
        l=self.lowestCommonAncestor(root.left,p,q)
        r=self.lowestCommonAncestor(root.right,p,q)

        if l and r:
            return root 

        return l or r 




# → Visiting Node: 3
#   Going LEFT from 3...
#   → Visiting Node: 5
#     ⭐ Found target node p (5)! Bubbling it up.
#   Going RIGHT from 3...
#   → Visiting Node: 1
#     Going LEFT from 1...
#     → Visiting Node: 0
#       Going LEFT from 0...
#       → Visiting: None (Reached a leaf or empty node)
#       Going RIGHT from 0...
#       → Visiting: None (Reached a leaf or empty node)
#       Checked children of 0 -> Left returned: None, Right returned: None
#       Returning None up to parent node.
#     Going RIGHT from 1...
#     → Visiting Node: 8
#       Going LEFT from 8...
#       → Visiting: None (Reached a leaf or empty node)
#       Going RIGHT from 8...
#       → Visiting: None (Reached a leaf or empty node)
#       Checked children of 8 -> Left returned: None, Right returned: None
#       Returning None up to parent node.
#     Checked children of 1 -> Left returned: None, Right returned: None
#     Returning None up to parent node.
#   Checked children of 3 -> Left returned: 5, Right returned: None
#   Returning 5 up to parent node.