#Time: O(n)
#Space: O(n)
#Program ran on leetcode successfully

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    
    def __init__(self):
        self.pathp = []
        self.pathq = []
        
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        if root is None:
            return None
        self.helper(root, p, q, [])
        for i in range(len(self.pathp)):
            if (self.pathp[i] != self.pathq[i]):
                return self.pathp[i-1]
        
        return None
    
    def helper(self, root, p, q, path):
        if root is None:
            return
        path.append(root)
        if (root == p):
            self.pathp = copy.deepcopy(path)
            self.pathp.append(root)
            self.pathp.append(root)
        if (root == q):
            self.pathq = copy.deepcopy(path)
            self.pathq.append(root)
            self.pathq.append(root)
        
        self.helper(root.left, p, q, path)
        self.helper(root.right, p, q, path)
        
        path.remove(path[-1])