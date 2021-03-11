#TimeComplexity:MAX(O(Depth+K) or O(N) )
#SpaceComplexity: O(Depth)
#Did this code successfully run on Leetcode : Yes 
#Any problem you faced while coding this : No
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        stack=[]#Iterative approach going till the leaf doing inorder traversal
        while True:
            while root:
                stack.append(root)#append all left nodes till you reach leaf
                root=root.left
    
            k-=1
            root=stack.pop()#taking root element
            if k==0:
                return root.val
            root=root.right #going to right subtree
            