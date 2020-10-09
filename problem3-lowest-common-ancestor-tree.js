//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
//runtime:
//space:
//leetcode: yes
//problems:
//explanation:

// searchvals = [p, q]
// recurse over tree postorder (left, right, root)

// recurse(node) {
//   if (node.left != null) leftnode = recurse(node.left)
//   if (node.right != null) rightnode = recurse(node.right)

//   cases:
//   1) node with no left or right
//   2) node with just left
//   3) node with just right
//   4) node with both

//   1)
//   if node.left == null and node.right == null and node.val in searchvals
//     remove node.val from searchvals
//     return node

//   2)
//   if leftnode != null and rightnode == null
//      return leftnode

//   3)
//   if leftnode is null and rightnode isnt null
//      return rightnode

//   4)
//   return node
// }

// return recurse(root)

///**
// * Definition for a binary tree node.
// * function TreeNode(val) {
// *     this.val = val;
// *     this.left = this.right = null;
// * }
// */
///**
// * @param {TreeNode} root
// * @param {TreeNode} p
// * @param {TreeNode} q
// * @return {TreeNode}
// */
var lowestCommonAncestor;

lowestCommonAncestor = function(root, p, q) {
  var recurse;
  recurse = function(node) {
    if (node.left === null && node.right === null && (node.val === p || node.val === q)) {
      return node;
    }
    if (node.left !== null && node.right === null) {
      return node.left;
    }
    if (node.right !== null) {
      return node.right;
    }
    return node;
  };
  return recurse(root);
};

//# sourceMappingURL=problem3-lowest-common-ancestor-tree.js.map
