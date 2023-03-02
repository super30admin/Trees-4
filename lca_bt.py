# time Complexity: O(N)
# space Complexity: O(N)

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    pathP = []
    pathQ = []

    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        def helper(root, p, q, nums):
            # Base
            if root == None:
                return
            # Logic
            if root.val == p.val:
                temp = nums[:]
                self.pathP = temp
                self.pathP.append(p)
                self.pathP.append(p)
            if root.val == q.val:
                temp = nums[:]
                self.pathQ = temp
                self.pathQ.append(q)
                self.pathQ.append(q)

            nums.append(root)
            helper(root.left, p, q, nums)
            helper(root.right, p, q, nums)
            nums.pop()

        helper(root, p, q, [])
        for i in range(len(self.pathP)):
            if self.pathP[i] != self.pathQ[i]:
                return self.pathQ[i-1]
