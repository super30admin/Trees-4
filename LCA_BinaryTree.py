# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    """by tracking path of both p and q, we get to know the LCA
    Time complexity-O(n)
    Space complexity-O(h) for arrays and internally using stack for recursion"""
    def __init__(self):
        self.arr1=[]
        self.arr2=[]
        
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        arr=[]
        self.helper(root, p, q, arr)
        for i in range(len(self.arr1)):
            if self.arr1[i].val!=self.arr2[i].val:
                return self.arr1[i-1]
                
    def helper(self, root, p, q, arr):
        if not root:
            return None
        if root.val==p.val:
            self.arr1=arr[:]
            self.arr1.append(root)
            self.arr1.append(root)
        if root.val==q.val:
            self.arr2=arr[:]
            self.arr2.append(root)
            self.arr2.append(root)
        if self.arr1 and self.arr2:
            return
        arr.append(root)
        self.helper(root.left, p, q, arr)
        self.helper(root.right, p, q, arr)
        arr.pop()
        
        """Bottom Up Approach
        Time complexity-O(n)
        Space complexity-no auxilary space used, using onlyunderhood stack"""
        # if not root:
        #     return None
        # if root.val==p.val or root.val==q.val:
        #     return root
        # left=self.lowestCommonAncestor(root.left,p,q)
        # right=self.lowestCommonAncestor(root.right,p,q)
        # if left!=None and right!=None:
        #     return root
        # elif left!=None:
        #     return left
        # elif right!=None:
        #     return right
        # else:
        #     return None
        

        
            
            
        