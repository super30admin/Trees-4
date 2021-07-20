"""
Recursive Apporoach
Time Complexity: O(n) n= number of nodes
Space Complexity: O(n)
"""
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        self.count=0 #nodes bet 0 to 1 million
        self.result=-1
        self.inorder(root,k)
        return self.result

    def inorder(self,root,k):
        if root==None:
            return None

        if self.result==-1:
            self.inorder(root.left,k)
        #st.pop() under hood, increase count at this position

        self.count+=1

        if(self.count==k):
            self.result=root.val

        self.inorder(root.right,k)




