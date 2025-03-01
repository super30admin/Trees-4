# tc O(n), sc O(1).
node = root
while node:
    if (p.val < node.val < q.val) or (q.val < node.val < p.val):
        return node
    
    if (p.val == node.val) or (q.val == node.val):
        return node
    
    if p.val < node.val and q.val < node.val:
        node = node.left
    else:
        node = node.right