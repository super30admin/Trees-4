// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
        if(p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        else return root;

    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//o(n)time and o(h) space for recurssion stack
class Solution {

    List<TreeNode> pathP;
    List<TreeNode> pathQ;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == root || q == root) return root;
        pathP = new ArrayList<>();
        pathQ = new ArrayList<>();
        backtrack(root, p, q, new ArrayList<>());
        //iterate through both paths
        for(int i = 0; i < pathP.size(); i++){
            if(pathP.get(i) != pathQ.get(i)){
                return pathP.get(i -1 );
            }
        }
        return null;
    }
    private void backtrack(TreeNode root, TreeNode p, TreeNode q, ArrayList path){
        if(root == null) return;

        path.add(root);
        if(p.val == root.val){
            pathP = new ArrayList<>(path);
            pathP.add(p);

        }
        if(q.val == root.val){
            pathQ = new ArrayList<>(path);
            pathQ.add(q);

        }
        backtrack(root.left, p, q, path);
        backtrack(root.right, p, q, path);

        path.remove(path.size() - 1);
    }
}
//(o(log(N)) time and o(h) recurrsion stack space
class Solution {
    int result;
    int count;
    public int kthSmallest(TreeNode root, int k) {
        result =-1;
        count = k;
        inorder(root);
        return result;
    }
    private void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        count--;
        if(count == 0){
            result = root.val;
            return;
        }
        inorder(root.right);
    }
}