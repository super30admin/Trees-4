"""

Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.


Example 1:

Input: root = [3,1,4,null,2], k = 1
Output: 1

Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3
 
Constraints:

The number of nodes in the tree is n.
1 <= k <= n <= 104
0 <= Node.val <= 104

Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?


Time Complexity:
- Iterative Approach: O(k) (since we traverse only the first k nodes of the inorder traversal)
- Recursive Approach: O(k) (since we stop traversal once k-th element is found)

Space Complexity:
- Iterative Approach: O(h) (stack stores at most h elements, where h is tree height)
- Recursive Approach: O(h) (recursive call stack goes up to height h in worst case)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""

# This function finds the k-th smallest element in a Binary Search Tree (BST) using two approaches:  
# 1. Iterative Inorder Traversal with a stack (O(k) time, O(h) space).  
# 2. Recursive Inorder Traversal with a class variable (O(k) time, O(h) space).  


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        
        # Iterative Inorder Traversal  
        n = 0
        stack = []
        cur = root

        while cur or stack:
            while cur:
                stack.append(cur)
                cur = cur.left  # Move left

            cur = stack.pop()  # Process node
            n += 1
            if n == k:
                return cur.val  # Found k-th smallest

            cur = cur.right  # Move right

        # Recursive Inorder Traversal
        self.res = None
        self.k = k
        
        def inorder(node):
            if not node or self.res is not None:
                return

            inorder(node.left)  # Traverse left

            self.k -= 1
            if self.k == 0:
                self.res = node.val  # Store result
                return

            inorder(node.right)  # Traverse right

        inorder(root)
        return self.res  # Return result from recursion

