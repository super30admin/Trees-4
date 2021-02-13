#time: O(n)
#space:O(h)

#iterative Approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    result=-1
    count=0
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        if(root==None):
            return -1
        stack=[]
        while(root!=None or stack!=[]):
            while(root!=None):
                stack.append(root)
                root=root.left
            root=stack.pop()
            k-=1
            if(k==0):
                return root.val
            root=root.right
            
            