#Time complexity: O(k)
#Space complexity: O(k)
#Works on leetcode: yes
#Approach: To get the kth smallest, we need do inorder traversal using a stack while decrementing k by 1 whenever we pop from 
#stack. When k is 0, we just return the value.

class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        stack = []
        while root or stack:
            while root:
                stack.append(root)
                root = root.left
            root = stack.pop()
            k-=1
            if k==0:
                return root.val
            root=root.right 