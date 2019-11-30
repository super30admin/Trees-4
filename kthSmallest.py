# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


# time complexity: O(N)
# class Solution:
#     def kthSmallest(self, root: TreeNode, k: int) -> int:
#         #brute force -iterative
#         #in order traversal of the tree
#         #return the k-1th element from the resultant list

#         result=[]
#         stack=[]
#         current=root
#         while True:
#             if current is not None:
#                     stack.append(current)
#                     current=current.left
#             elif stack:
#                     current=stack.pop()
#                     result.append(current.val)
#                     current=current.right
#             else:
#                 break
#         return result[k-1]

# time cimplexity: 0(N)
"""
class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        #brute force -recursive
        #in order traversal of the tree
        #return the k-1th element from the resultant list
        result=[]
        self.helper(root,result)
        return result[k-1]
    def helper(self,root,result):
        if not root:
            return
        self.helper(root.left,result)
        result.append(root.val)
        self.helper(root.right,result)
"""


# time complexity:O(k+h)
# explaination:instead of iterating through the whole tree, pop the elements from the stack k times, that is until k becomes zero
class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        stack = []
        while root != None or len(stack) > 0:
            while root != None:
                stack.append(root)
                root = root.left
            root = stack.pop()
            k -= 1
            if k == 0:
                return root.val
            root = root.right

