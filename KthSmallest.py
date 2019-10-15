"""
The approach here is very simple just do a inorder traversal and store the values in the array and return 
the kth index from the array.
A optimization for this could be to keep the count of k and decrease the value of k at every node traversal
and then when your k value hits 0 return the node value.
Leetcode - Running
Time complexity - O(N)
Space Complexity - O(N)

"""

def kthSmallest(self, root, k):
        arr = self.inorder(root)
        return arr[k-1]
        
        
def inorder(self,root):
    res = []
    if root == None:
        return res
    if root:
        res = self.inorder(root.left)
        res.append(root.val)
        res = res + self.inorder(root.right)
    return res