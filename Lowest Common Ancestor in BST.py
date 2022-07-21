# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

    # Time Complexity: O(h)
    # Space Complexity: O(h)

#iterative method
class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        while True:
            if p.val<root.val and q.val<root.val: root=root.left
            elif p.val>root.val and q.val>root.val: root=root.right
            else: return root

'''
    # Time Complexity: O(h)
    # Space Complexity: O(h)
class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        print(root.val)
        if p.val<root.val and q.val<root.val: return self.lowestCommonAncestor( root.left, p, q)
        elif p.val>root.val and q.val>root.val: return self.lowestCommonAncestor( root.right, p, q)
        else: return root
'''
