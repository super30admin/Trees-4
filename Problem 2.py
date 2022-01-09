# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
# Time : O(n)
# Space: O(n)
# Time: O(n)
class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        dic_p = {}
        lis_q = []
        curr = root
        while True:
            dic_p[curr] = True
            if curr.val == p.val:
                break
            if p.val > curr.val:
                curr = curr.right
            else:
                curr = curr.left
        curr = root
        while True:
            lis_q.append(curr)
            if curr.val == q.val:
                break
            if q.val > curr.val:
                curr = curr.right
            else:
                curr = curr.left
        for node in lis_q[::-1]:
            if node in dic_p:
                return node

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
# Time : O(n)
# SPace: O(n) # If we include space consumed by recursive stack
class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        if root.val < p.val and root.val < q.val:
            return self.lowestCommonAncestor(root.right, p, q)
        elif root.val > p.val and root.val > q.val:
            return self.lowestCommonAncestor(root.left, p, q)
        else:
            return root
            
            
        
            
        
