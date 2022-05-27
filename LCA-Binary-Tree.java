//time - O(m+n)
//space - O(m+n)
class Solution {
    List<TreeNode> pList;
    List<TreeNode> qList;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        pList = new ArrayList<>();
        qList = new ArrayList<>();
        dfs(root, p, q, new ArrayList<>());
        int i=0,j=0;
        TreeNode res = null;
        while(i<pList.size() && j<qList.size()){
            if(pList.get(i)==qList.get(j))
                res = pList.get(i);
            else
                break;
            i++;
            j++;
        }
        return res;
    }
    private void dfs(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path){
        if(root==null) return;

        path.add(root);
        if(root==p){
            pList = new ArrayList<>(path);
        }
        if(root==q){
            qList = new ArrayList<>(path);
        }

        dfs(root.left, p, q, path);
        dfs(root.right, p, q, path);
        path.remove(path.size()-1);
    }
}