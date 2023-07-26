#Time complexity is O(h)
#Spacec omplexity is O(h)
#No issues faced while coding
#Code ran successfully on leetcode

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def kthSmallest(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: int
        """
        #initializing the required variables
        self.result=None
        self.count=k
        #We will be performing inorder traversal
        self.inorder(root)
        #We will be returning the kth smallest value
        return self.result.val
    
    def inorder(self,root):
        #base
        #If root is equal to None, we return nothing
        if(root==None):
            return
        #logic
        if(self.result==None):
            #We will be going through the left of the tree
            self.inorder(root.left)
        #We will start subtracting 1 from the count
        self.count-=1
        if(self.count==0):
            #If the count is equal to zero, it means it is the kth smallest value and we assign that to the result treenode
            self.result=root
        if(self.result==None):
            #We will be going through the left of the tree
            self.inorder(root.right)