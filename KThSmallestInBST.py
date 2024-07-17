# Time Complexity:
# O(n)

# Space Complexity:  
# O(h)

# Approach: 
# Iterative approach, using node pointers


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def __init__(self):
        self.cnt = 0
        self.answer = 0
    def kthSmallest(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: int
        """
        # Approach 2: Iterative
        if not root:
            return
        stack = [] 
        while root or stack:
            while root:
                stack.append(root)
                root = root.left
            root = stack.pop()
            k -= 1
            if k == 0:
                return root.val
            root = root.right