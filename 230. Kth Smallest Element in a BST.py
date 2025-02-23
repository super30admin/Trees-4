#time: O(n)
#space: O(h)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# We will do inorder traversal, since its sorted in ascending order for bst. for every execution of code for inorder that is the call between root.left and root.right, we will decrement the count of the k and when k reaches 0, we will return the answer
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.answer= int()
        self.k=k
        self.dfs(root)
        return self.answer

    def dfs(self,root):
        if root == None or self.k ==0:
            return
        self.dfs(root.left)
        print('root is ', root.val, 'k is', self.k)
        self.k -= 1
        if ( self.k ==0):
            self.answer = root.val
            return
        self.dfs(root.right)
        
