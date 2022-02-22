// Time Complexity :O(H+K) H is the height of the tree
// Space Complexity :O(H) 
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach



class Solution {
    public int kthSmallest(TreeNode root, int k) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()){
		
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
			
        TreeNode node = stack.pop();
            //stack.pop();
            k--;
            if(k == 0) return node.val;
            
			curr = node.right;
           // curr = curr.right;
        }
        return -1;
    }
}


lowest-common-ancestor-of-a-binary-search-tree
//Time complexity : O(N)
//Space complexity: O(N)

class Solution {


public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
    else if (p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
    else return root;
}
}



lowest-common-ancestor-of-a-binary-tree
//Time complexity : O(N)
//Space complexity : O(N)

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p , q);
        if (left == null && right == null) return null;
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }
}


