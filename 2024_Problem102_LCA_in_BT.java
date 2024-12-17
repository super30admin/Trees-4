//236. Lowest Common Ancestor in a Binary Tree - https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
//Time Complexity: O(n) + O(h)
//Space Complexity: O(h)

//Recursion + Backtracking
class Solution {
    List<TreeNode> pathP;
    List<TreeNode> pathQ;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //logic
        helper(root, p, q, new ArrayList<>());
        for(int i=0; i<pathP.size(); i++){ //iterate over any list to find common ancestor
            if(pathP.get(i) != pathQ.get(i)){
                return pathP.get(i-1); //previous node is the common ancestor
            }
        }
        return null;
    }

    private void helper(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path){
        //base case
        if(root == null) return;
        //logic
        //action
        path.add(root);//add root to the List
        if(root == p){ //if root is p
            pathP = new ArrayList<>(path);
            pathP.add(root);
        }
        if(root == q){ //if root is q
            pathQ = new ArrayList<>(path);
            pathQ.add(root);
        }
        //recurse
        helper(root.left, p, q, path);
        helper(root.right, p, q, path);
        //backtrack
        path.remove(path.size()-1); //after processing left-right, then backtrack
    }
}


//Time Complexity: O(n)
//Space Complexity: O(h)
//Recursive (Bottom-Up Approach)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base case
        if(root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null && right == null) return null; //return null to parent
        else if(left == null && right != null) return right; //return non null element to the root
        else if(left != null && right == null) return left;
        else return root;
    }
}