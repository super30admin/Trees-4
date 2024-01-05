'''
DFS and use 2 nonlocal variables count and ans, then return ans once you get it, and only go tp right if count<k
Then TC: O(h + k) and SC: O(h)

we could store total number of nodes present at each node
and use the left count to determine if k is present on left, curr node or right

this has
TC: O(h) // h = n for sewked tree and h=logn for balanced tree
SC: O(1) // iterative solution 

'''

class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        count = 0
        ans = -1
        
        def dfs(node):
            nonlocal ans, count
            if not node:
                return
        
            
            if node.left:
                dfs(node.left)
            count += 1

            if count == k:
                ans = node.val
            
            if node.right:
                dfs(node.right)
        
        dfs(root)
        return ans