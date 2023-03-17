# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#All TC passed on leetcode


class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        
        #Here we perform inorder traversal and get kth smallest node. Inorder traversal gives ascending order of nodes, hence we get the kth smallest node from inorder traversal
        #Time complexity - O(n) - where n is all nodes in tree
        #Space complexity - O(h) - stack space can go max ht of tree
        self.count = k
        self.res = -1

        def inorder(root):
            if not root:
                return
            
            inorder(root.left)
            self.count-=1
            if self.count==0:
                self.res = root.val

            inorder(root.right)

        
        inorder(root)
        return self.res

        