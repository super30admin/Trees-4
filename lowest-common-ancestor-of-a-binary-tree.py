"""

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

 
Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.

Example 2:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

Example 3:

Input: root = [1,2], p = 1, q = 2
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [2, 105].
-109 <= Node.val <= 109
All Node.val are unique.
p != q
p and q will exist in the tree.


Time Complexity: O(N), where N is the number of nodes in the tree (each node is visited once).
Space Complexity: O(H), where H is the height of the tree (O(log N) for balanced trees, O(N) for skewed trees).

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""

# Approach:
# used Depth-First Search (DFS) to traverse the tree and find nodes p and q. 
# If both nodes are found in different subtrees, the current node is the Lowest Common Ancestor (LCA).
# If only one node is found, we return it, as it means both nodes are in the same subtree.


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
      
        def dfs(cur):
            if not cur:
                return None
            if cur == p or cur == q:
                return cur

            left = dfs(cur.left)
            right = dfs(cur.right)

            if left and right:
                return cur

            return left if left else right

        return dfs(root)

