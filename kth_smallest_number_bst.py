# Iterative solution
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
we use a stack for iterative approach.As it is BST we traverse to the left most side of the tree to get the least element.Then we see if there is a right side to the node if yes we traverse one right and then traverse to the left till we reach to the end.we do this for k .when k==0 then we get the node value.

# Time complexity --> o(k)
# space complexity --> o(k)
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def kthSmallest(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: int
        """
        if root==None:
            return 0
        stack=[]
        while k>0:
            while(root!=None):
                stack.append(root)
                root=root.left
            k=k-1
            root=stack.pop()
            if k==0:
                return root.val
            if root:
                root=root.right
                

#Recursive solution
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
we do inorder traversal as it gives the elements in BST in ascending order.so we maintain a count whenever the inorder traversal.when the count is 0 then we return the node value.

# Time complexity --> o(k)
# space complexity --> o(k)
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def __init__(self):
        self.k=None
        self.result=0
    
    def helper(self,root):
        if root==None:
            return
        self.helper(root.left)
        self.k=self.k-1
        # print(self.k,root.val)
        if self.k==0:
            self.result=root.val
        self.helper(root.right)
        return self.result
        
    def kthSmallest(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: int
        """
        self.k=k
        if root==None:
            return 0
        return self.helper(root)