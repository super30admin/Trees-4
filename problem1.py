"""
While the root exists, we exploit the property of BST and check which side of the tree does the parent lie
if it does answer the first two call, then we can be sure that the root we are exploring is the parent
O(H) TC for a balanced tree and O(N) for a skewed one and SC is O(1)"""

class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        curr = root
        while curr:
            if p.val < curr.val and q.val < curr.val:
                curr = curr.left
            elif p.val > curr.val and q.val > curr.val:
                curr = curr.right
            else:
                return curr
        