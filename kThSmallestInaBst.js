// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes

// Further optimization by not traversing the right sub tree if k === 0
var kthSmallest = function (root, k) {
  let kthElement = 0;
  const inorderTrav = (root) => {
    // base
    if (!root) return;

    // Logic
    inorderTrav(root.left);
    k--;
    if (!k) return (kthElement = root.val);
    if (k > 0) inorderTrav(root.right);
  };

  inorderTrav(root);
  return kthElement;
};

// Time Complexity : O(n)
// Space Complexity : O(h)
var kthSmallest = function (root, k) {
  let kthElement = 0;
  const inorderTrav = (root) => {
    // base
    if (!root) return;

    // Logic
    inorderTrav(root.left);
    k--;
    if (!k) return (kthElement = root.val);
    inorderTrav(root.right);
  };

  inorderTrav(root);
  return kthElement;
};

// Time Complexity : O(n)
// Space Complexity : O(h + n): recursive stack and array space
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

// var kthSmallest = function(root, k) {
//   const inorderTrav = (root) => {
//       // base
//       if (!root) return;

//       // Logic
//       inorderTrav(root.left)
//       k--
//       if (!k) return kthElement = root.val
//       inorderTrav(root.right)
//   }

//   return inorderTrav(root);
// };
