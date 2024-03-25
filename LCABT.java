// Time Complexity : O(n),number of nodes.
// Space Complexity : O(h),  recursive stack space,  Worst case O(n)
//where h = height of the tree (max recursion calls at one point)
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english : Keep the path of finding p and q, and then compare where the path differs,i.e LCA

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<TreeNode> pList;
    List<TreeNode> qList;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        pList = new ArrayList<>();
        qList = new ArrayList<>();
        dfs(root, p, q, new ArrayList<TreeNode>());
        
        int i = 0;
        while(pList.get(i) == qList.get(i)){
            i++;
        }
        return pList.get(i-1);

    }

    private void dfs(TreeNode root, TreeNode p, TreeNode q,List<TreeNode> path){
        //base
        if(root == null) return;
        if(root == p){
            pList = new ArrayList<>(path);
            pList.add(p);
            pList.add(p);
        }
        if(root == q){
            qList =  new ArrayList<>(path);
            qList.add(q);
            qList.add(q);
        }

        //logic
        path.add(root);
        //recurse
        if(pList.isEmpty() || qList.isEmpty()){
            dfs(root.left, p, q, path);

            dfs(root.right, p, q, path);
        }
        

        //backtrack
        path.remove(path.size() -1);

    }
}

//Bottom Up approach
// Time Complexity : O(n),number of nodes.
// Space Complexity : O(h),  recursive stack space. Worst case O(n)
//where h = height of the tree (max recursion calls at one point)
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english : return the node to parent if root == p or q, else return null.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }

        //logic

        TreeNode left = lowestCommonAncestor(root.left, p, q);

        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if(left == null && right == null){
            return null;
        }
        else if(left != null && right == null){
            return left;
        }
        else if(right != null && left == null){
            return right;
        }
        else{ 
            return root;
        }
    }
}