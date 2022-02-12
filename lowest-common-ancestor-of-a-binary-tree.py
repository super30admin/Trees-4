'''
TC: O(n)
SC: O(h)
'''
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
        
        def iot(node, p, q, plist, qlist, path):
            if not node:
                return
            if node == p:
                plist += path
                plist.append(p)
            if node == q:
                qlist += path
                qlist.append(q)
            iot(node.left, p, q, plist, qlist, path + [node])
            iot(node.right, p, q, plist, qlist, path + [node])
        
        plist, qlist = list(), list()
        iot(root, p, q, plist, qlist, [])
        
        # handle edge case when plist = [1, 2] and qlist = [1, 2, 3, 4], answer = 2
        plist.append(p)
        qlist.append(q)
        i = 0
        
        while i < len(plist) and i < len(qlist):
            if plist[i].val != qlist[i].val:
                return plist[i - 1]
            i += 1
        
        return -1