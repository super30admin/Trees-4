'''
T =max (O(k), O(h+k))
S =O(h)

Approach:
Perform Inorder traversal for k times and return the result
'''



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.count = 0
        self.result = 0
        
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        if not root:
            return None
        self.inorder(root,k)
        return self.result
    
    def inorder(self,Node,K):
        if Node == None:
            return
        
        self.inorder(Node.left,K)
        self.count += 1
        
        if self.count == K:
            self.result = Node.val
            return self.result
        self.inorder(Node.right,K)