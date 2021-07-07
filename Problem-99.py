'''
Lett code : 230 - Kth smallest element IN BST - https://leetcode.com/problems/kth-smallest-element-in-a-bst/
time complexity -O(N)
space complexity -O(N)
Approach - Inorder traversal and find the Kth element in a list

'''
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    
    def __init__(self):
        self.list=[]
        
    def kthSmallest(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: int
        """
        self.inorder(root)
        return self.list[k-1]
        
    def inorder(self,root):
        #base case
        if not root: return
        
        self.inorder(root.left)
        self.list.append(root.val)
        self.inorder(root.right)
        
        
# using physical stack (not a recursive stack) - Time complexity - O(H+K)  - we are going till the left elements and K.

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution(object):
    def kthSmallest(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: int
        """
        stack=[]
        while True:
            while root:
                stack.append(root)
                root=root.left
            root=stack.pop()
            k=k-1
            if k==0:
                 return root.val
            root=root.right
                