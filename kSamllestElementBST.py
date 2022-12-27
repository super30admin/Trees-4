# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#we can make use of Binary Search

'''
Time Complexity --> O(nlogn)
Space Complexity --> O(n)
'''
class Solution:

    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        def lowval(root):
            if root.left!=None:
                return lowval(root.left)
            else:
                return root.val
        def highval(root):
            if root.right!=None:
                return highval(root.right)
            else:
                return root.val
        

        def Count(low, mid):
            j = 0
            while low<mid:
                j+=1
                low+=1
            return j 
        low = lowval(root)
        high = highval(root)
        l = low
       
        while low<high:
            #print('low',low,end=' ')
            #print('high',high,end=' ')
            mid = (low+high)//2
            #print('mid',mid,end=' ')
            v = Count(l,mid)
            #print('v',v)
            if v==k-1:
                return mid
            if v<k:
                low = mid+1
            else:
                high = mid
        return low
            