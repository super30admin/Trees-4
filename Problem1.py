# Problem1: Kth Smallest Element in a BST (https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/)
# Time Complexity: O(n) in the worst case where k equals n, because we may need to visit every node before we find the answer. In the best case it is closer to O(h) since we can stop early.
# Space Complexity: O(h) where h is the height of the tree, because that is the maximum depth the recursive call stack can reach.
# Approach:
# We do an inorder traversal of the tree because inorder traversal on a BST visits nodes in sorted order.
# We use a counter to track how many nodes we have visited so far in that sorted order.
# Once we reach the kth node we save it as the result and we stop making new recursive calls once the result is found so we do not waste time visiting the rest of the tree.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.count = 0  # tracks how many nodes we have visited so far across all recursive calls
        self.result = None  # will hold the node we are looking for once we find it
        self.helper(root, k)  # start the inorder traversal from the root
        return self.result.val  # once traversal is done, result holds our answer node, so return its value
    
    def helper(self, root, k):
        if root is None:
            return  # base case, there is nothing to visit here so stop this path
        
        if self.result is None:
            self.helper(root.left, k)  # go left first since inorder visits left side before the node itself, but only if we have not already found the answer
        self.count += 1  # we are now visiting this node, so increase the count
        if self.count == k:
            self.result = root  # this is the kth node in sorted order, so save it as our answer
        if self.result is None:
            self.helper(root.right, k)  # go right after visiting the node, but again only if we still have not found the answer