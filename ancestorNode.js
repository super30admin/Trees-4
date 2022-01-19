// Time Complexity : O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Optimized approach:
var lowestCommonAncestor = function (root, p, q) {
  if (!root) return null;
  let ancestralNode;
  const dfs = (root) => {
    // base condition
    if (
      (root.val <= p.val && root.val >= q.val) ||
      (root.val >= p.val && root.val <= q.val)
    ) {
      ancestralNode = root;
      return root;
    }

    // action
    if (root && root.val > p.val && root.val > q.val) {
      return dfs(root.left);
    }
    if (root && root.val < p.val && root.val < q.val) {
      return dfs(root.right);
    }
  };

  dfs(root);
  return ancestralNode;
};

// Time Complexity : O(n + n): first n is for traversing the tree, and the second is for looping through holdingArr.
// Space Complexity : O(h + h): first h is for recursive stack and second h is for items in holdingArr.
var lowestCommonAncestor = function (root, p, q) {
  if (!root) return null;
  const holdingArr = [];
  const dfs = (root, path) => {
    // base condition
    if (root === null) return;

    // action
    path.push(root);
    if (root === p || root === q) {
      const newArr = [...path];
      holdingArr.push(newArr);
    }
    dfs(root.left, path);
    dfs(root.right, path);

    // backtrack
    path.pop();
  };

  dfs(root, []);
  let ancestralNode;
  for (let i = 0; i < holdingArr[0].length; i++) {
    if (
      holdingArr[0][i] &&
      holdingArr[1][i] &&
      holdingArr[0][i].val === holdingArr[1][i].val
    ) {
      ancestralNode = holdingArr[0][i];
    } else {
      break;
    }
  }
  return ancestralNode;
};
