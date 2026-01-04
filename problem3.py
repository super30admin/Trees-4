"""
We maintain a stack and perform inorder traversal, and while popping elements we read, we keep decrementing k count and once it reaches 0, due to sorted nature of inorder traversal, 
we can see that the popped element will be our answer
TC is O(N) and SC is O(H) for height
"""
class Solution(object):
    def kthSmallest(self, root, k):
        """
        :type root: Optional[TreeNode]
        :type k: int
        :rtype: int
        """
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
        return -1
            