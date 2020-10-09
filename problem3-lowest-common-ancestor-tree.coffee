#https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
#runtime: O(n) visit all n nodes
#space: O(max depth) recursive stack
#leetcode: yes and no (some bugs)
#problems: doesn't work for all cases not sure why
#explanation:
#
# recurse on root preorder
#   if root is null return nul
#   if root.val is p.val or q.val return root
#
#   left = recurse(root.left)
#   right = recurse(root.right)
#
#   if left and right aren't null return root
#   if left isnt null return left
#   return right
#

#/**
# * Definition for a binary tree node.
# * function TreeNode(val) {
# *     this.val = val;
# *     this.left = this.right = null;
# * }
# */
#/**
# * @param {TreeNode} root
# * @param {TreeNode} p
# * @param {TreeNode} q
# * @return {TreeNode}
# */
lowestCommonAncestor = (root, p, q) ->
  return null if root is null
  return root if p.val is root.val or q.val is root.val

  left = lowestCommonAncestor(root.left, p, q)
  right = lowestCommonAncestor(root.right, p, q)

  if left isnt null and right isnt null
    return root
  else if left isnt null
    return root.left
  return root.right
