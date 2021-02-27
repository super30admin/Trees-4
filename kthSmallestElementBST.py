# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

#Accepted on leetcode
#Time complexity - O(h+k) as we traverse nodes at each level until kth node
#Space omplexity - O(h+k) since we are using physical stack

class Solution(object):
    def kthSmallest(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: int
        """
        stack = []
        while root != None or len(stack) > 0:
            while root != None:
                stack.append(root)
                root = root.left
            root = stack.pop()
            k -= 1
            if k == 0:
                break
            root = root.right
        return root.val