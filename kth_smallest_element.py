# Time Complexity :
# O(N) - Number of nodes

# Space Complexity :
# O(H) - height of the tree

# Did this code successfully run on Leetcode :
#Yes

#We do an inorder traversal of the tree and keep a count of the number of values encountered. As soon as this number reaches k, we store that as the required return value and at the end of the recursion, we return the stored value

class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.count = 0
        self.return_val = -1
        self.k = k
        node = self.inorder(root)
        return self.return_val

    def inorder(self,root):
        if root == None :
            return 0
        if self.return_val == -1 :
            left_nos = self.inorder(root.left)
        self.count += 1
        if self.count == self.k :
            self.return_val = root.val
            return
        if self.return_val == -1 :
            right_nos = self.inorder(root.right)
