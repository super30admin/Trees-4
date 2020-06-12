"""
    // Time Complexity :O(n) + O(nlogn)
    // Space Complexity :O(1)
    // Did this code successfully run on Leetcode : YES
    // Any problem you faced while coding this : NA

    //Explanation:
    traverse whole BST in BFS and add numbers in min heap
    pop the element from heap for i < k
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
import heapq
import collections
class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:

        size = 0
        queue = collections.deque([])
        pq = []
        heapq.heapify(pq)
        result = None

        #custom lambda function
        lessThan = lambda x,y : x.val < y.val
        TreeNode.__lt__ = lessThan

        currentNode = None
        queue.append(root)

        while queue:
            n = len(queue)
            for i in range(len(queue)):
                currentNode = queue.popleft()
                if currentNode.left is not None:
                    queue.append(currentNode.left)
                if currentNode.right is not None:
                    queue.append(currentNode.right)

                heapq.heappush(pq,currentNode)


        i = 0
        while i < k :
            result = heapq.heappop(pq)
            i += 1
        return result.val
