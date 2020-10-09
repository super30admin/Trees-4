//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
//runtime: O(n) visit all n nodes
//space: O(max depth) recursive stack
//leetcode: yes and no (some bugs)
//problems: doesn't work for all cases not sure why
//explanation:

// recurse on root preorder
//   if root is null return nul
//   if root.val is p.val or q.val return root

//   left = recurse(root.left)
//   right = recurse(root.right)

//   if left and right aren't null return root
//   if left isnt null return left
//   return right

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
  var left, right;
  if (root === null) {
    return null;
  }
  if (p.val === root.val || q.val === root.val) {
    return root;
  }
  left = lowestCommonAncestor(root.left, p, q);
  right = lowestCommonAncestor(root.right, p, q);
  if (left !== null && right !== null) {
    return root;
  } else if (left !== null) {
    return left;
  }
  return right;
};

//# sourceMappingURL=problem3-lowest-common-ancestor-tree.js.map
