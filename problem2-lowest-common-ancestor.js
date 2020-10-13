//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
//runtime: O(lg n)
//space: O(max depth of tree)
//leetcode: yes
//problems: i was returning node.val but leetcode wanted the node itself returned
//explanation:

// at each root
//    if root is null return -1
//    case p and q are less than root, root = root.left
//    case p and q are greater than root, root = root.right
//    else root is the answer

///**
// * Definition for a binary tree node.
// * function TreeNode(val) {
// *     this.val = val;
// *     this.left = this.right = null;
// * }
// */
var TreeNode, lowestCommonAncestor;

TreeNode = function(val = -1, left = null, right = null) {
  return Object.assign(Object.create(TreeNode.prototype), {
    val: val,
    left: left,
    right: right
  });
};

///**
// * @param {TreeNode} root
// * @param {TreeNode} p
// * @param {TreeNode} q
// * @return {TreeNode}
// */
lowestCommonAncestor = function(root, p, q) {
  var recurse;
  recurse = function(node) {
    if (node === null) {
      return null;
    }
    if (p.val < node.val && q.val < node.val) {
      return recurse(node.left);
    }
    if (p.val > node.val && q.val > node.val) {
      return recurse(node.right);
    }
    return node;
  };
  return recurse(root);
};

//# sourceMappingURL=problem2-lowest-common-ancestor.js.map
