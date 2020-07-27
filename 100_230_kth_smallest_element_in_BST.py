# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:

        # Method 3 : inorder traversal: Recursive approach
        # Time complexity : O(n)
        # traverse all nodes
        # Space complexity :O ( height) , stack space under the hood

        # Method 3 : inorder traversal: Iterative aproach
        # Time complexity : O(n),
        # traverse all nodes
        # Space complexity : O(h) ( height) , stack space over the hood
        # no external DS needed , stack space under the hood

        '''
        - try inorder , ascending order
        - do not forget to return root.val and NOT root itself
        '''
        while root == None: return 0

        node = TreeNode()
        stack = []
        while root != None or len(stack) != 0:
            while root != None:
                stack.append(root)
                root = root.left

            root = stack.pop()  # popped element
            k -= 1  # pop k elements out of the stack
            print(k)
            if k == 0: return root.val
            root = root.right
