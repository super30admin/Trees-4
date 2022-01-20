// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes

var kthSmallest = function (root, k) {
  const resultsArr = [];
  const inorderTrav = (root) => {
    // base
    if (!root) return;

    // logic
    inorderTrav(root.left);
    resultsArr.push(root.val);
    inorderTrav(root.right);
  };

  inorderTrav(root);
  return resultsArr[k - 1];
};
