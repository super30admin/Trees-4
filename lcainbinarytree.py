'''// Time Complexity : O(n) 
// Space Complexity : O(h) - stack space (h - height of tree)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
'''
class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        # If the current node is either none, p or q, return the current node
        if root == None or root == p or root == q:
            return root
        
        # Recur on the left and right subtrees
        left = self.lowestCommonAncestor(root.left,p,q)
        right = self.lowestCommonAncestor(root.right,p,q)
        
        # If both left and right are not None, it means p and q are found in
        # different subtrees, so the current node is the LCA
        # If either left or right is not None, return the one that is not None
        if left == None and right == None:
            return None
        elif left == None and right != None:
            return right
        elif left != None and right == None:
            return left
        else:
            return root
        