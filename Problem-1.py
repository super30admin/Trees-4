#Time Complexity :O(n) 
#Space Complexity :o(h) 
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this :no
class Solution(object):
    def kthSmallest(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: int
        """
        stack=[]
        while(True):
            while(root!=None):
                stack.append(root)
                root=root.left
            root=stack.pop()
            #decrement k each time we pop when k==o we are at the kth smallest node
            k-=1
            if(k==0):
                return root.val
            root=root.right
            