# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    # tc : O(k) - > O(n) when k = n worst case so O(n)
    # sc : O(h) where h is the depth of the tree space used by recrussive stack 
    # ran successfully on leetcode
    def kthSmallest(self, root, k):
        """
        :type root: Optional[TreeNode]
        :type k: int
        :rtype: int
        """
        # we must return the kth smallest so since its a bst we can traverse inorder from left of the tree first, then root, right and while traversing we will keep track of the count once we reach the count equal to k then we have found
        # the kth smallest element

        self.result = None
        self.count = 0
        self.helper(root,k)
        return self.result.val

    def helper(self,root,k):
        # base
        if root is None :
            return 
        
        # action
        if self.result is None : # havign conditional check so that we perform until we find result and no longer
           self.helper(root.left,k)
        self.count +=1 # traversed left and then root add up the count 
        if self.count == k: # if we are at the kth node in out inorder traversal then we got the kth smallest element 
            self.result = root
        if self.result is None:
            self.helper(root.right,k)
    

        