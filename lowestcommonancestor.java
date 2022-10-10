/*
Time Complexity: O(N)
Space Complexity: O(N)
*/
class Solution {
    private List<TreeNode> firstPath = new ArrayList<>(); 
    private List<TreeNode> path = new ArrayList<>(); 
    private TreeNode result;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q, 0); 
        return result;
    }
    
    public void dfs(TreeNode node, TreeNode p, TreeNode q, int level) {
        if(path.size() > level) path.set(level, node);
        else path.add(node);
        
        if(node.val == p.val || node.val == q.val) handleEqual(level);
        
        if(node.left != null) dfs(node.left, p, q, level + 1);
        if(node.right != null) dfs(node.right, p, q, level + 1);
    }
    public void handleEqual(int level){
        if(firstPath.isEmpty())  
            for(int i = 0; i <= level; i++)  firstPath.add(path.get(i)); 
        else {
            for(int i = 0; i <= level; i++) {
                if(i == path.size() || i == firstPath.size() || firstPath.get(i).val != path.get(i).val) break;
                result = path.get(i); 
            }
        }
    }
}