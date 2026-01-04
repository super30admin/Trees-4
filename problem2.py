"""
We recursiely check both the subtrees and compare their answers, if there exist no LCA, both will return None, if one side returns non null and other side null, we can recusively
check on that side of subtree, and if both return non null, we have the curr node as the LCA
O(N) time operation and O(H) space for the recursive stack
 
"""
class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        if root is None or root == q or root == p:
            return root
        left = self.lowestCommonAncestor( root.left, p, q)
        right = self.lowestCommonAncestor( root.right, p, q)

        if left is None and right is None:
            return None
        elif left is None and right is not None:
            return right
        elif left is not None and right is None:
            return left
        else:
            return root
        
        