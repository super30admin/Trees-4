//https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
//runtime: O(n)
//space: O(max depth)
//leetcode: yes
//problems: none
//explanation:
// do an inorder traversal of a tree
// whenever you visit the root, k -= 1
// when k is 0 then return the root value you popped
var TreeNode, kthSmallest;

TreeNode = function(val = -1, left = null, right = null) {
  return Object.assign(Object.create(TreeNode.prototype), {
    val: val,
    left: left,
    right: right
  });
};

kthSmallest = function(root, k) {
  var count, stack, visit;
  if (root === null) {
    return -1;
  }
  stack = [];
  count = 0;
  while (stack.length !== 0 || root !== null) {
    while (root !== null) {
      stack.push(root);
      root = root.left;
    }
    // visit root
    visit = stack.pop();
    count += 1;
    if (count === k) {
      return visit.val;
    }
    root = visit.right;
  }
  return -1;
};

//# sourceMappingURL=problem1-kth-smallest-element-bst.js.map
