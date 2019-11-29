'''
https://leetcode.com/problems/kth-smallest-element-in-a-bst
Did it run on leetcode: Yes
Did you face any problem: No

Time Complexity: 0(K)
Space Compleixty: 0(min(K,H)) where h is height of the tree

Algorithm:
- an inorder traversal of a tree is an sorted order of increasing in array
- while doing an inorder traversal keep a count of number of elemnts you are popping in the stack.
- When the number==K its the `K` smallest element.

'''


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
        
        current = root
        stack = []
        count = 0
        
        while current or len(stack)>0:
            
            while current:
                stack.append(current)
                current = current.left
            current = stack.pop()
            count+=1
            if count==k:
                return current.val
            current = current.right
        
        return -1