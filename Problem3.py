#Time complexity: O(n)
#Space complexity: O(height of BT)
#Works on leetcode: yes
#Approach: If the current subtree contains both p and q, then the function result is their LCA. If only one of them 
#is in that subtree, then the result is that one of them. If neither are in that subtree, the result is None.


class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        if not root or root==p or root==q:
            return root
        l = self.lowestCommonAncestor(root.left,p,q)
        r = self.lowestCommonAncestor(root.right,p,q)
        if l and r:
            return root
        return l if l else r