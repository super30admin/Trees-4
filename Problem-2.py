#Time Complexity :O(logn)
#Space Complexity :O(h) 
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this : No
class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        #p and q values are less than root so go on left side
        if(p.val < root.val and q.val<root.val):
            return self.lowestCommonAncestor(root.left,p,q)
        elif(p.val > root.val and q.val>root.val):
            return self.lowestCommonAncestor(root.right,p,q)
        else:
            return root
            