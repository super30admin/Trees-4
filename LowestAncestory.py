"""
The Approach here is to search for p and q in both the left and right sub-trees, The first condition is
to see if at a given point the node is either p or q, the two recursive function call indicate searching 
for p and q both left and right side of the tree, and at any point when both p and q values are found,then
a AND operation will result in TRUE and hence at that point the current root is lowest common ancestor.

LeetCode - Running
Time complexity - O(N)
Space complexity - O(N) - recursion stack.
"""
def lowestCommonAncestor(self, root, p, q):
        if (not root) or (root == p) or (root == q):
            return root
        # search left and right subtree
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)
        if left and right:
            # both found, root is the LCA
            return root
        return left or right