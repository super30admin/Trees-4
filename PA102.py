#Time Complexity - O(h)
#Space Complexity - O(h)
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from collections import defaultdict
class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        ans = self.helper(root,p)
        ans1 = self.helper(root,q)
        d = defaultdict(int)
        for i in ans1:
            d[i] = 1
        for i in ans[::-1]:
            if d[i] == 1:
                return i
    def helper(self,root,p):
        ans = []
        if not root:
            return TreeNode("")
        stack = []
        d = defaultdict(int)
        stack.append(root)
        while stack:
            node = stack[-1]
            if node and d[node] != 1 and node != p:
                d[node] = 1
            if node.left and d[node.left] != 1:
                stack.append(node.left)
                d[node.left] = 1
            elif not node.left and not node.right:
                if node == p:
                    for i in stack:
                        ans.append(i)
                    return ans
                stack.pop()
            else:
                if node.right and d[node.right] != 1:
                    stack.append(node.right)
                    d[node.right] = 1
                elif node == p:
                    for i in stack:
                        ans.append(i)
                    return ans
                else:
                    stack.pop()
        
        