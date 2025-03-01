# tc O(n), sc O(n).
if not root:
    return None

if root == p or root == q:
    return root

left = self.lowestCommonAncestor(root.left, p, q)
right = self.lowestCommonAncestor(root.right, p, q)

if left and right:
    return root

if left:
    return left

return right