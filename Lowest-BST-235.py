# Time Complexity : O(n)
# Space Complexity : O(maxdepth)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        res = root
        while res:
            if p.val < res.val and q.val < res.val:
                res = res.left
            elif p.val > res.val and q.val > res.val:
                res = res.right
            else:
                return res
