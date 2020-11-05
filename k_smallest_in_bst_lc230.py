"""
Author-Srinidhi
Did it run on LC: Yes

Time Complexity: O(H+k) - In worst case, after convering the height, you might have to travel k nodes 
Space Complexity: O(H) - In the stack at max h nodes will be there. Is skewed this will be O(N)


Logic - Inorder traversal in BST gives us the sorted order of the node values - BST propoerty
In this case
Iterative >> Recursion - No need to iterate throught the entire tree like recursion
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        if root is None:
            return -1
        
        stack = []
        
        while True:
            while root:
                stack.append(root)
                root = root.left
                
            root = stack.pop()
            k = k - 1
            
            if k == 0:
                return root.val
            root = root.right