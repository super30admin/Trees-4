# TimeCOmplexity:O(H + k)
# SpaceComplexity:O(H+K)


#brute force do in order and after that traverse through inorder list . but do we need list or do we need to prcoess elements after hiting kth element to solve this we can jsut maintain a count
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        
        count = 0
        stack = []
        cur = root

        while stack or cur:

            while cur:
                stack.append(cur)
                cur = cur.left

            cur = stack.pop()

            count += 1
            if count == k:
                return cur.val

            cur = cur.right
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        #brute force do in order and after that traverse through inorder list . but do we need list or do we need to prcoess elements after hiting kth element to solve this we can jsut maintain a count
        self.count=k
        self.ans=-1
        def helper(root):
            if  root== None :return 
           
            helper(root.left)
            self.count-=1
            
            if self.count==0:
                self.ans=root.val
                 
               
           
            helper(root.right)
        helper(root)
        return self.ans


        




# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        #brute force do in order and after that traverse through inorder lsit
        inorder=[]
        def inor(root):
            if not root:return 
            inor(root.left)
            inorder.append(root.val)
            inor(root.right)
        inor(root)
        return inorder[k-1]
