# time complexity is o(n), where n is number of nodes in tree.
# space complexity is o(h), h = log(n), where n is the number of nodes in the tree.(Recursive stack space)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    res = None
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.count = k
        return self.helper(root, k).val
    
    def helper(self, root, k):
        if(root == None):
            return None
        
        l = self.helper(root.left, k)
        if(l):
            return l
        self.count -= 1
        if(self.count == 0):
            return root
        return self.helper(root.right, k)
        # if(r):
        #     return r
        # if(not l and not r):
        #     return None
        
        
        
#         self.count = k
#         self.helper(root, k)
#         return self.res.val
    
#     def helper(self, root, k):
#         if(root == None):
#             return 
        
#         self.helper(root.left, k)
#         self.count -= 1
#         if(self.count == 0):
#             self.res = root
#             return
#         self.helper(root.right, k)
        
        
        
        
        
#         nodeList = list()
#         self.helper(root, nodeList)
#         class rootval:
#             def __init__(self, val):
#                 self.val = val
#             # def __lt__(self, other):
#             #     return self.val > other.val
#         morethan  = lambda x,y: x.val > y.val
#         rootval.__lt__ = morethan
        
#         from heapq import heappush
#         from heapq import heappop
#         heap = []
#         for i in nodeList:
#             temp = rootval(i)
#             heappush(heap, temp)
#             while(len(heap) > k):
#                 heappop(heap)
#         return heap[0].val
        
        
#     def helper(self, root, res):
#         #base
#         if(root == None):
#             return 
        
#         #logic
#         res.append(root.val)
#         self.helper(root.left, res)
#         self.helper(root.right, res)
#         return
        
        
        