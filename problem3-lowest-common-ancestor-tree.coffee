#https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
#runtime:
#space:
#leetcode: yes
#problems:
#explanation:
#
# searchvals = [p, q]
# recurse over tree postorder (left, right, root)
#
# recurse(node) {
#   if (node.left != null) leftnode = recurse(node.left)
#   if (node.right != null) rightnode = recurse(node.right)
#
#   cases:
#   1) node with no left or right
#   2) node with just left
#   3) node with just right
#   4) node with both

#   1)
#   if node.left == null and node.right == null and node.val in searchvals
#     remove node.val from searchvals
#     return node

#   2)
#   if leftnode != null and rightnode == null
#      return leftnode
#
#   3)
#   if leftnode is null and rightnode isnt null
#      return rightnode
#
#   4)
#   return node
# }
#
# return recurse(root)
#
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
  recurse = (node) ->
    if node.left is null and node.right is null and (node.val is p or node.val is q)
      return node

    if node.left isnt null and node.right is null
      return node.left

    if node.right isnt null
      return node.right

    return node

  recurse(root)
