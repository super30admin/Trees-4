# TC: O(n)
# SC: O(1)

def lowestCommonAncestor(root, p, q):
    if not root or root == p or root == q:
        return root

    l = lowestCommonAncestor(root.left, p, q)
    r = lowestCommonAncestor(root.right, p, q)

    if l and r:
        return root
        
    return l or r

