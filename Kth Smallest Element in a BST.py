# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    #Solution 1
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        #Approach: Morris Inorder Tree Traversal
        #Time Complexity: O(n)
        #Space Complexity: O(1)

        curr = root
        
        while curr:
            if not curr.left:
                k -= 1
                if k == 0:
                    return curr.val
                
                curr = curr.right
            
            else:
                predecessor = curr.left
                while predecessor.right and predecessor.right != curr:
                    predecessor = predecessor.right
                
                #left not visited before; move left and establish link
                if not predecessor.right:
                    predecessor.right = curr
                    curr = curr.left
                
                #left visited before; move right and remove link
                else: #predecessor.right == curr
                    predecessor.right = None
                
                    k -= 1
                    if k == 0:
                        return curr.val
                
                    curr = curr.right
    
    #Solution 2
    """
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        #Approach: Recursive DFS
        #Time Complexity: O(n)
        #Space Complexity: O(h) #under the hood

        self.k = k
        self.result = None
        self.kthSmallestHelper(root, k)
        
        return self.result.val
    
    def kthSmallestHelper(self, root, k):
        #base
        if not root:
            return
        
        #logic
        self.kthSmallestHelper(root.left, k)
        self.k -= 1
        
        if self.k == 0:
            self.result = root
            return
        
        if self.result == None: #to suppress recursion after the solution is found
            self.kthSmallestHelper(root.right, k)
    """
    
    #Solution 3
    """
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        #Approach: Iterative DFS
        #Time Complexity: O(n)
        #Space Complexity: O(h)
        
        st = []
        while root or st:
            while root:
                st.append(root)
                root = root.left
            root = st.pop()
            
            k -= 1
            if k == 0:
                return root.val
            
            root = root.right
    """