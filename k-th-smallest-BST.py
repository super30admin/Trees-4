"""
Runtime Complexity:
O(n) - in the worst case the 'k' smallest element might be at the end of the tree, therefore our inorder will need to traverse all the way upto the end. 
The overall runtime complexity is O(n)- to traverse 'n' nodes. We optimised this solution by initialising result to -1 and count to k. In best case we might find the
element in the left subtree itself and not go to right tree.
Space Complexity:
O(h) - recursive stack
Yes, the code worked on leetcode.
Issues while coding-No 

"""
class Solution:
    count = 0
    result = 0
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        if not root:
            return -1
        self.count = k
        self.result = -1
        self.inorder(root)
        return self.result
    
    def inorder(self,root):
        if not root:
            return
        if self.result == -1:
            self.inorder(root.left)
        self.count-=1
        
        if self.count ==0:
            self.result = root.val
            return
        self.inorder(root.right)
            
        