// Time Complexity :O(log n) in the worst case where n is the number of nodes in the tree
// Space Complexity :O(log n) in the worst case where n is the number of nodes in the tree
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :
import java.util.ArrayList;
import java.util.List;

public class LCABST {
    private List<TreeNode> pPath;
    private List<TreeNode> qPath;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        pPath = new ArrayList<>();
        qPath = new ArrayList<>();
        preOrder(root, p, pPath);
        preOrder(root, q, qPath);
        int idx = 0;
        TreeNode lca = root;
        while(idx < pPath.size() && idx < qPath.size()){
            if(pPath.get(idx) == qPath.get(idx)){
                lca = pPath.get(idx);
            }
            idx++;
        }
        return lca;
    }

    private void preOrder(TreeNode node, TreeNode endNode, List<TreeNode> path){
        //base
        if(node == null){
            return;
        }
        //logic
        path.add(node);
        if(node == endNode){
            return;
        }
        if(endNode.val < node.val){
            preOrder(node.left, endNode, path);
        }else{
            preOrder(node.right, endNode, path);
        }
    }
}
