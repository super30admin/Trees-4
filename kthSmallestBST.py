# // Time Complexity :O(h) 
# // Space Complexity :O(h) 
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Incorrect basecase for helper


# using Stack iterative
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        st = []

        while st or root:
            while root:
                st.append(root)
                root = root.left                    # left bb
            root = st.pop()
            k -=1
            if k==0:
                return root.val                     # right bb
            root = root.right


# using recursion DC
class Solution:
    def __init__(self):
        self.res = 0
        self.count = 0

    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.helper(root,k)
        return self.res

    def helper(self, root, k):
        #basecase
        if root == None:
            return

        #logic
        if self.res == 0:                                       # fast exit
            self.helper(root.left, k)       # rec
        
        self.count +=1                      # cond : inorder
        if self.count == k:                 
            self.res = root.val

        if self.res == 0:                                       # fast exit
            self.helper(root.right, k)      # rec