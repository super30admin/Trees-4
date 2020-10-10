# Time Complexity : O(n)
# Space Complexity : O(maxdepth)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution(object):
    def kthSmallest(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: int
        """
        if root is None:
            return None
        stack = []
        current = root
        count = 0
        while True:
            if current is not None:
                stack.append(current)
                current = current.left
            elif stack:
                current = stack.pop()
                count += 1
                if count == k:
                    return current.val
                current = current.right
            else:
                break
