# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        # Space: O(h) on average, O(n) worst case
        # Time: O(n)
        if(root==None):
            return 0
        
        
        i = 0
        def recursiveTraversal(root):            
            nonlocal i
            if(root.left!=None):
                val = recursiveTraversal(root.left) # 5,3
            if(k==i): #i =1
                return val
            i += 1 # i=3, i=4 i=5
            if(k==i or root.right==None):
                return root.val
            return recursiveTraversal(root.right)        
        val = recursiveTraversal(root)
        return val
        
        
        
        st = []
        
        def iterTraversal(root):
            if(root==None):
                return
            while(root!=None):
                nonlocal st
                st.append(root)
                root = root.left
        
        iterTraversal(root)
        i=0
        while(len(st)>0):
            e = st.pop()
            i+=1
            if(i==k):
                return e.val
            iterTraversal(e.right)
        
        return 0
        
