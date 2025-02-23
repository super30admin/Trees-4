# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        if not root:
            return 0
        curr=root
        stack=[]
        cnt=0
        while curr or stack:
            while curr:
                stack.append(curr)
                curr=curr.left
            curr = stack.pop()
            cnt+=1
            if cnt==k:
                return curr.val
            curr=curr.right
        return 0
            

        