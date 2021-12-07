#Time: O(n)
#Space: O(n)
class Solution:
    x=0
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        
        self.x=k
        
        return self.helper(root)
        
        #Iterative
        s=[]
        
        while s or root:
            while root:
                s.append(root)
                root=root.left
                
            root=s.pop()
            k-=1
            if k==0:
                return root.val
            
            root=root.right
            
        return -1
    
    
#Recursive approach
    def helper(self,root):
        
        if root is None:
            return float('inf')
        
        l=self.helper(root.left)
        
        self.x-=1
        
        if self.x==0:
            return root.val
        
        r=self.helper(root.right)
        
       
        return min(l,r)