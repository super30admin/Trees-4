"""
TC: O(n)
"""
class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        def LCAHelper(node):
            if node is None:
                return None
            resLeft = LCAHelper(node.left)
            resRight = LCAHelper(node.right)
            if (resLeft and resRight) or (node in [p,q]) :
                return node
            else:
                return resLeft or resRight
        
        return LCAHelper(root)
