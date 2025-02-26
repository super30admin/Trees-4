# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        # Approach 1: Inorder Traversal (Recursive)
        # Time Complexity : O(n) because we are traversing each and every element in the tree
        #Sc - O(1)
        # res = []
        
        # def inorder(node):
        #     if not node:
        #         return
        #     inorder(node.left)
        #     res.append(node.val)
        #     inorder(node.right)
        
        # inorder(root)
        # return res[k - 1]

        ## Approach 2
        # Time Complexity : O(nlogk) because we are adding every element into the queue and a priority queue

# Space Complexity : O(k) we are maintaining a priority queue of size k
        pq = []
        queue = deque([root])
        heapq.heappush(pq, -root.val)
        
        while queue:
            temp = queue.popleft()
            if temp.left:
                queue.append(temp.left)
                heapq.heappush(pq, -temp.left.val)
            if temp.right:
                queue.append(temp.right)
                heapq.heappush(pq, -temp.right.val)
        
        while len(pq) > k:
            heapq.heappop(pq)
        return -heapq.heappop(pq)
        
