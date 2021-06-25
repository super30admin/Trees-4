#time : 0(n)
class Solution(object):
    
    def kthSmallest(self, root, k):
        
        stack = []
        
        while True :
            while root:
                stack.append(root)
                root = root.left

            root = stack.pop()
            k = k - 1

            if k == 0:
                return root.val

            root = root.right
        """
        :type root: TreeNode
        :type k: int
        :rtype: int
        """