"""
Time Complexity: O(N)
Space Complexity: O(h)
# Using Recursion
Utilizing the property of inorder traversal
we keep a count and keep doing inorder traversal till we reach the count, recursively
"""
class Solution(object):
    
    def kthSmallest(self, root, k):
        """
        :type root: Optional[TreeNode]
        :type k: int
        :rtype: int
        """
        self.count = k
        self.result = None
        self.helper(root);
        return self.result.val;

    def helper(self,root):
        if root == None:
            return
        self.helper(root.left)
        self.count -=1
        if self.count == 0:
            self.result = root
        self.helper(root.right)

'''
Time Complexity: O(N)
Space Complexity: O(h)
# Using Stack
'''
def kthSmallest(self, root, k):
        """
        :type root: Optional[TreeNode]
        :type k: int
        :rtype: int
        """
        stack = []
        while root!=None or stack !=[]:
            while root:
                stack.append(root)
                root = root.left
            root = stack.pop()
            k-=1
            if k == 0:
                return root.val
            root = root.right