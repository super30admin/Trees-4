#230. Kth Smallest Element in a BST
# Time Complexity : O(n) 
# Space Complexity :O(h)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
class Solution:
     count = 0
     res = 0
     def kthSmallest(self, root: TreeNode, k: int) -> int:   
         self.count = k
         self.inorder(root)
         return self.res

     def inorder(self,root):
         if not root:
             return 
         self.inorder(root.left)
         self.count -= 1 
         if self.count == 0:
             self.res = root.val
             return 
         self.inorder(root.right)

    # Iterative approach 
    # Time = O(n) | Space = O(h) 
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        st = []
        while len(st) != 0 or root != None:
            while root:
                st.append(root)
                root = root.left 

            node = st.pop()
            k -= 1 
            if k == 0:
                return node.val
            root = node.right 
        return None 