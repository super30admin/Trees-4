#Time Complexity: O(k), as the function traverses the tree nodes in an in-order fashion and stops once the kth smallest element is found.
#Space Complexity: O(h), where h is the height of the tree, due to the recursive call stack.
class Solution:
    count = 0
    result = 0
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.helper(root, k)
        return self.result
    def helper(self, root, k):
        if(root==None):
            return None
        if(self.count<k):
            self.helper(root.left,k)
        self.count+=1
        if(self.count==k):
            self.result = root.val
            return self.result
        if(self.count<k):
            self.helper(root.right,k)