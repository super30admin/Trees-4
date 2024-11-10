// Time Complexity : O(h) - height of the tree
// Space Complexity : O(h) - height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
'''
Using the property of BST, nodes on left are smaller than root and nodes on right are greater than root
if we ever find the case that one node is either the root or lies on one side of root , and the other node lies on other side - we can say that the root is the LCA
'''
class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        if root.val > p.val and root.val > q.val:
            return self.lowestCommonAncestor(root.left,p,q)
        elif root.val < p.val and root.val < q.val:
            return self.lowestCommonAncestor(root.right,p,q)
        else:
            return root
        
        '''
        We can do it without recursion
        while True:
            if root.val < p.val and root.val < q.val:
                root = root.right   
            elif root.val > p.val and root.val > q.val:
                root = root.left
            else:
                return root
        '''