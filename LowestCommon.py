"""
The approach here is to check with the root node value and p and q value everytime since it's a bst left 
side elements would be less and right would be greater than root, so at every point we check if p is less
than root and q is greater than root or viceversa, id so we return the particular root val as the answer,
else if both p and q are greater than we change our root to right node of root or else if both are smaller
than to the left node.
Space complexity - O(1)
Time complexity - O(N)
Leetcode running
"""
while root:
        if p.val <= root.val <= q.val or q.val <= root.val <= p.val:
            return root 
        if p.val > root.val and q.val > root.val:
            root = root.right
        elif p.val < root.val and q.val < root.val:
            root = root.left