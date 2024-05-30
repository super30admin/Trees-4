import java.util.ArrayList;
import java.util.List;
import javax.swing.tree.TreeNode;

//TC: O(n)
//SC: O(h)
public class Problem3 {
List<TreeNode> pathP;
    List<TreeNode> pathQ;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q, new ArrayList<>());
        for(int i=0;i<pathP.size();i++){
          if(pathP.get(i)!=pathQ.get(i)){
            return pathP.get(i-1);
          }
        }
        return null;
    }

    private void helper(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path){
      // base
      if(root == null) return;

      //action
      path.add(root);
      if(root==p){
        pathP = new ArrayList<>(path);
        pathP.add(root);
      }

      if(root==q){
        pathQ = new ArrayList<>(path);
        pathQ.add(root);
      }

      //recurse
      if(pathP==null || pathQ == null){
        helper(root.left, p, q, path);
      }
      if(pathP==null || pathQ == null){
        helper(root.right, p, q, path);
      }
      //backtrack
      path.remove(path.size()-1);
    }
}
