# tc O(n), sc O(n).
# Iterative approach.
stack = deque()

while True:
    while root:
        stack.append(root)
        root = root.left
    
    root = stack.pop()
    k -= 1
    if not k:
        return root.val
    
    root = root.right