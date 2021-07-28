# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        #iterative
        #Time complexity: O(h)
        #space complexity: O(1)
        while True:
            if p.val>root.val and q.val>root.val:
                root = root.right
            elif p.val<root.val and q.val<root.val:
                root = root.left
            else:
                return root
        #recursive
        #Time complexity: O(h)
        #space complexity: O(h)
        #if both greater than root, move right, otherwise move left
        # if p.val>root.val and q.val>root.val:
        #     return self.lowestCommonAncestor(root.right,p,q)
        # elif p.val<root.val and q.val<root.val:
        #     return self.lowestCommonAncestor(root.left,p,q)
        # else:
        #     return root
