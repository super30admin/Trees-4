# // Time Complexity :O(height)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No

# we implemented two types- recursive and iterative solution. here we check the val we want to find is greater than the root or lesser than the root and move accordingly. 
class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        # recursive solution O(n) O(h)
        # if(root.val>p.val and root.val>q.val):
        #     return self.lowestCommonAncestor(root.left,p,q)
        # elif(root.val<p.val and root.val<q.val):
        #     return self.lowestCommonAncestor(root.right,p,q)
        # else:
        #     return root

        # iterative solution O(h) O(1)
        while(True):
            if(root.val>p.val and root.val>q.val):
                root=root.left
            elif(root.val<p.val and root.val<q.val):
                root=root.right
            else:
                return root