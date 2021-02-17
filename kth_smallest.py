# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time : O(n+k)
# Space: O(n) worst case h = n for skewed bst
class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        # Iterative inorder traversal
        mystack = []
        while(len(mystack) > 0 or root != None):
            while(root != None):
                mystack.append(root)
                root = root.left
            curr = mystack.pop()
            k -= 1
            # found kth smallest at k=0
            if(k == 0):
                return curr.val
            root = curr.right