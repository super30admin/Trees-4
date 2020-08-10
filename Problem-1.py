# Time Complexity :O(n)
# Space Complexity :O(1) 
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
class Solution(object):
    def kthSmallest(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: int
        """
        # create stack
        stack = []
        #dfs
        while root or stack:
            #go to left end of array
            while root:
                stack.append(root)
                root = root.left
            #check current
            root =stack.pop()
            #minus from k if it reaches zero return
            k-=1
            if k == 0:
                return root.val
            #check right
            root = root.right