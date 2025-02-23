/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Time Complexity :O(n)
//Space Complexity:O(n)
class Solution {
    List<TreeNode> pathp;
    List<TreeNode> pathq;
      
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       if (root == null ){
        return root;
       } 

       pathp = new ArrayList<>();
       pathq = new ArrayList<>();

        dfs (root, p,q, new ArrayList<>());

        for (int i =0;i < pathp.size();i++){
            if (pathp.get(i)!= pathq.get(i))
            return pathp.get(i-1);
        }
        return null;
    }

private void dfs (TreeNode root, TreeNode p, TreeNode q, List<TreeNode> list){
//base case
if (root == null || (pathp.size() > 0 && pathq.size() >0))
return;

//logic
    list.add (root);
    if (root == p){
        pathp = new ArrayList<>(list);
        pathp.add(p);
    }
    if (root == q){
        pathq = new ArrayList<>(list);
        pathq.add(q);
    }
    dfs (root.left, p,q,list);
    dfs (root.right, p,q,list);
    list.remove(list.size()-1);
}
}
