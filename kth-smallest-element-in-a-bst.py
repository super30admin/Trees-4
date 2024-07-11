# Time Complexity : O(n)
# Space Complexity : O(h)
from typing import Optional, TreeNode
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        #iterative method
        stack = []
        while root!= None or stack:
            while root != None:
                stack.append(root)
                root = root.left
            root = stack.pop()
            k-=1
            if k == 0:
                return root.val
            root = root.right