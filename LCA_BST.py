#Time Complexity: O(h), h is height of the tree
#Space Complexity: O(1)
class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        while root:
            if p.val < root.val and q.val < root.val:
                root = root.left  # move left
            elif p.val > root.val and q.val > root.val:
                root = root.right  # move right
            else:
                return root  