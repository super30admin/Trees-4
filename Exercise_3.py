# Time Complexity: O(n)
# Space Complexity: O(h) where h is the height of the tree, worse case - O(n)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        if not root:
            return
        
        def helper(node, path):
            if not node:
                return 
            
            if node.val == p.val:
                self.plist = list(path)
                self.plist.append(p)
                
            if node.val == q.val:
                self.qlist = list(path)
                self.qlist.append(q)
                
            path.append(node.left)
            helper(node.left, path)
            path.pop()
            
            path.append(node.right)
            helper(node.right, path)
            path.pop()
        
        self.plist = []
        self.qlist = []
        path = []
        path.append(root)
        helper(root, path)
        
        for i in range(len(self.plist)):
            if self.plist[i].val!=self.qlist[i].val:
                return self.plist[i-1]       