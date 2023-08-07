# // Time Complexity :O(h)
# // Space Complexity :O(k)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No
class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        if root:
            # If the value of p node and the q node is greater than the value of root node...
            if root.val > p.val and root.val > q.val:
                return self.lowestCommonAncestor(root.left, p, q)
            # If the value of p node and the q node is less than the value of root node...
            elif root.val < p.val and root.val < q.val:
                return self.lowestCommonAncestor(root.right, p, q)
            else:
                return root