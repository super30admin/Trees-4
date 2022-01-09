# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time: O(n)
# Space: O(n)

class Solution(object):
    def kthSmallest(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: int
        """
        n = 1
        stack = []
        curr = root
        stack.append(curr)
        while len(stack) != 0:
            while curr != None:
                curr = curr.left
                if curr != None:
                    stack.append(curr)
            #print(stack)
            #print('*'*100)
            curr = stack.pop()
            if n == k:
                return curr.val
            n += 1
            curr = curr.right
            if curr!= None:
                stack.append(curr)
        
        
