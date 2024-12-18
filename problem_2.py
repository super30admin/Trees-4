# TC: O(n)
# SC: O(1)

def lowestCommonAncestor(root, p, q):
    def helper(root, p, q):
        if not root: return

        if root.val > p.val and root.val > q.val:
            return helper(root.left, p, q)
        elif root.val < p.val and root.val < q.val:
            return helper(root.right, p ,q)
        else:
            return root
    
    return helper(root, p, q)