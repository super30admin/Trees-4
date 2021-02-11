// Time Complexity : O(n)
// Space Complexity : O(h), h = height of the recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 

// Notes : Recurse the left part of the tree then the right part, while adding the root nodes to a list, and then backtracking it. Once p and q are found, create new result lists for each. Iterate through the lists to find the nearest common root between them and return it.


public class LowestCommonAncestorOfABinaryTree {
    List<TreeNode> descP;
    List<TreeNode> descQ;

    TreeNode p;
    TreeNode q;

    List<TreeNode> li;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root.left == null && root.right == null) return root;

        li = new ArrayList<>();

        this.p = p;
        this.q = q;

        dfs(root, li);
 
        for(int i = 1; i < Math.min(descP.size(), descQ.size()); i++ ){
            if(descP.get(i) != descQ.get(i)){
                return descP.get(i-1);
            } 
        }
        return descP.get(Math.min(descP.size(), descQ.size()) - 1);
    }

    private void dfs(TreeNode root, List<TreeNode> li){
        if(root == null || (descP != null && descQ != null) ) return;

        li.add(root);

        if(root.val == p.val){
            descP = new ArrayList<>(li);
        } else if(root.val == q.val){
            descQ = new ArrayList<>(li);
        }

        dfs(root.left, li);
        dfs(root.right, li);
        li.remove(li.size() - 1);
    }
}
