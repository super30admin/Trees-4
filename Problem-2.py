# Time Complexity :O(log n)
# Space Complexity :O(1) 
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        # while there is a root
        while root:
            # if > and > check left
            if root.val > p.val and root.val > q.val:
                root = root.left
            # if < and < check right
            elif root.val < p.val and root.val < q.val:
                root = root.right
            else:
                #else return True
                return root