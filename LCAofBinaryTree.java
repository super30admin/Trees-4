/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Approach : Recursion with backtracking by maintaining the path
// Time : O(n) + O(h)
// Space : O(h) + O(h) + O(h) // Recursive space and space for paths 
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2 = new ArrayList<>();

        backtrack(root,p,path1);
        backtrack(root,q,path2);
        for(int i =0;i<path1.size();i++){
            if(path1.get(i)!=path2.get(i)){
                return path1.get(i-1);
            }
        }

        return null;
        
    }

    public void backtrack(TreeNode root,TreeNode a,List<TreeNode> path){
        // Base case
        if(root == null){
            return;
        }
        if(root == a){
            path.add(root);
        }

        // logic
        path.add(root); // action
        backtrack(root.left,a,path); // recursion
        if(path.get(path.size()-1) == a) return;

        backtrack(root.right,a,path); // recursion
        if(path.get(path.size()-1) == a) return;

        // backtrack;
        path.remove(path.size()-1); // backtrack

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
// Approach : Recursion with backtracking by maintaining the path and building the pathp and pathq
// Time : O(n) + O(h)
// Space : O(h) + O(h) + O(h) // Recursive space and space for paths 
class Solution {
    List<TreeNode> pathp;
    List<TreeNode> pathq;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.pathp = new ArrayList<>();
        this.pathq = new ArrayList<>();

        helper(root,p,q,new ArrayList<>());
        for(int i=0;i<pathp.size();i++){
            if(pathp.get(i)!=pathq.get(i)){
                return pathp.get(i-1);
            }
        }

        return null;
    }

    public void helper(TreeNode root, TreeNode p, TreeNode q,List<TreeNode> path){
        // base case:
        if(root == null){
            return;
        }

        // logic
        path.add(root);
        if(p== root){
            pathp = new ArrayList<>(path);
            pathp.add(root);
        }

        if(q == root){
            pathq = new ArrayList<>(path);
            pathq.add(root);
        }

        // recursion
        helper(root.left,p,q,path);
        helper(root.right,p,q,path);

        // backtrack
        path.remove(path.size()-1);

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
// Approach : Bottom -to - top approach (looking the tree from bottom).At each everynode we are trying to collect left and right values
// and based on them . This approach will eliminate the space
// We are trying to identify at each and everynode whether we have reached p or q. If we have not reached either p or q then it returns null to its parent.
// Time : O(n) // visit all the nodes
// space : O(h) // just recursive space and no extra space.
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      // Base case
      if(root == null || root == p || root == q) return root;
      TreeNode left = lowestCommonAncestor(root.left,p,q);
      TreeNode right = lowestCommonAncestor(root.right,p,q); 

      if(left == null && right == null) return null;
      else if(left ==null && right!= null) return right;
      else if(left !=null && right == null) return left;
      else return root;
    }
}

