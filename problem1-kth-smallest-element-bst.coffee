#https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
#runtime: O(n)
#space: O(max depth)
#leetcode: yes
#problems: none
#explanation:
# do an inorder traversal of a tree
# whenever you visit the root, k -= 1
# when k is 0 then return the root value you popped

TreeNode = (val = -1, left = null, right = null) -> Object.assign(
  Object.create(TreeNode::),
    val: val
    left: left
    right: right
  )

kthSmallest = (root, k) ->
  return -1 if root is null

  stack = []
  count = 0

  while stack.length isnt 0 || root isnt null
    while root isnt null
      stack.push(root)
      root = root.left

    # visit root
    visit = stack.pop()
    count += 1
    return visit.val if count is k

    root = visit.right

  -1
