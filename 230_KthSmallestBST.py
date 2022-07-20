# Time Complexity : O(n)
# Space Complexity: O(1)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


# Do inorder traversal
# when we hit to the null, we increse a count
# when count == k, then return that node
# for ex, when we fount left most node, we will increse a count, bcz it is defenetly 1st smallest value in BST
# than 2nd will its parent, 3rd will right node, 4th wil parents' parents so on so....
class Solution:
    count = 0
    result = 0 
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.inorder(root,k)
        return self.result
    
    def inorder(self,root,k):
        if root == None:
            return
        self.inorder(root.left,k)
        self.count +=1
        if self.count ==k:
            self.result = root.val
            return
        self.inorder(root.right,k)