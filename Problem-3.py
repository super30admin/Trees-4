# Time Complexity :O(n)
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
        # if there is no root return None
        if not root: return
        # if you reach any of them propagate this node up
        if root == p or root == q:
            return root
        # check left tree for both
        l = self.lowestCommonAncestor(root.left,p,q)
        #check right tree for both
        r = self.lowestCommonAncestor(root.right,p,q)
        # when you find both left and right return root
        if l and r:
            return root
        else:
            # if left or right return the one you found of them
            return l or r