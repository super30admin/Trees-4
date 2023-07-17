# Time Complexity : O(n)
# Space Complexity : O(h) where h is the height of the treww
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#  
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        left = k
        res = None

        def helper(root):
            nonlocal left, res
            if not root:
                return
            helper(root.left)
            left -= 1
            if left == 0:
                res = root.val
                return
            helper(root.right)


        helper(root)
        return res