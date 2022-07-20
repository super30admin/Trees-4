# Approach: Iterative solution
# TC: O(k) as we will travel at most k elements.
# SC: O(h) which is height of the tree - in worst case O(N) and avg case O(logN)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:              
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        stack = []
        curr = root
        n = 0
        while curr or stack:  # while curr is not None or stack is not empty
            while curr:  # while curr is valid, push curr on to the stack and move to left
                stack.append(curr)
                curr = curr.left
            curr = stack.pop() # after all left childs are done, pop out the stack top
            n += 1 # increase n by 1
            if n == k:  # if its eq to k, return
                return curr.val
            curr = curr.right # move curr to right of curr node
     

# Approach: Recursive solution
# TC: O(k) as we will travel at most k elements.
# SC: O(h) which is height of the tree - in worst case O(N) and avg case O(logN)


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:              
    def __init__(self):
        self.i = self.res = 0
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        if not root: return True

        def traverse(node):
            if not node: 
                return 
            traverse(node.left)
            if node:
                self.i += 1
            if self.i == k:
                self.res = node.val
                return
            traverse(node.right)
        traverse(root)
        return self.res


"""Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?

Two possible solutions.
1) Traverse the tree and rebuild it with a modified object. At each node, keep the left_count that tells us how many nodes are there in the 
left subtree on the given tree. Every time we insert the new element, we keep modifiying the left_count as needed along the way. This still
gives us logarithmic time complexity. And when we need to find the kth element we can look at left_count and decide if we want to go towards
the left of a tree or go to write. This dramatically reduces our search space. We use k and left_count to compare how to proceed.
E.g. If k is 10 and our left count at the Root node is 8, then we know 10th smallest element won't be on the left side of the tree, but it will be on the right
so we reduce k as k - 8 - 1(for the root itself) and now go to root.right, and we need to find the 1st smallest element on that side as k = 1. 
Which is each again using the left_counts of the nodes.

2) Another way, specified on the leetcode is using an LRU cache like solution where we keep the serialized tree in a linked list, and we insert node in tree and
in the linked list and we also search in the linked list for kth smallest element. This is not as good as the first approach.
"""