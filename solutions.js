// ## Problem1 Kth Smallest Element in a BST 
// (https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/)


//iterative solution

//time: O(n)
//space: O(h)
//
const kthSmallest = function(root, k) {
   let st = [];
   while(root !== null || st.length !== 0) {
       while(root !== null) {
            st.push(root);
            root = root.left;
       }
       root = st.pop();
       k--;
       if(k === 0) return root.val;
       root = root.right;
   }
   return -1;
};

// recursive solution

const kthSmallest = function(root, k) {
    let res = -1;
    let count = k;
    inorder(root);
    return res;
    function inorder(root) {
        //base
        if(root === null) return;
        //logic
        inorder(root.left);
        count--;
        if(count === 0) {
            res = root.val;
            return;
        }
        inorder(root.right);
    }
}


// ## Problem2 Lowest Common Ancestor of a Binary Search Tree 
// (https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/)

//iterative
const lowestCommonAncestor = function(root, p, q) {
    while(root !== null) {
        if(root.val < p.val && root.val < q.val) root = root.right;
        else if(root.val > p.val && root.val > q.val) root = root.left;
        else return root;
    }
}


//recursive
const lowestCommonAncestor = function(root, p, q) {
    //base
    if(root === null) return null;
    //logic
    if(root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right,p,q);
    else if(root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left,p,q);
    else return root;
};



// ## Problem3 Lowest Common Ancestor of a Binary Tree 
// (https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/)