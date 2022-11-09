'''
Time Complexity: O(n)
Space Complexity: O(h)
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        count = [0]
        op = []
        def inorder(root):
            if (not root):
                return
            inorder(root.left)
            val = count.pop()
            val += 1
            count.append(val)
            if(count[0]==k):  
                op.append(root.val)
                return
            inorder(root.right)
        inorder(root)
        return op[0]
            
            