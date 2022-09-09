// Time Complexity : O(n)
// Space Complexity :O(h) where h is logn

class Solution {
    List<TreeNode> pathP;
    List<TreeNode> pathQ;
    boolean foundP;
    boolean foundQ;
    TreeNode common;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       pathP = new ArrayList<>();
       pathQ = new ArrayList<>(); 
       helper(root,p,q, new ArrayList<>());
        int m = pathP.size();
        int n = pathQ.size();

        int size = m<n ? m : n;
        for(int i=0;i<size;i++){
            if(pathP.get(i).val == pathQ.get(i).val)
            { common = pathP.get(i);
            }
        }
        return common;
    }
    
    public void helper(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path){
        if(root==null)
            return;
        if(root.val==p.val){
            pathP = new ArrayList<>(path);
            pathP.add(root);
            foundP=true;
        }
        if(root.val==q.val){
            pathQ = new ArrayList<>(path);
            pathQ.add(root);
            foundQ=true;
        }
        path.add(root);
        if(!foundP || !foundQ){
            helper(root.left,p,q,path);
            helper(root.right,p,q,path);
        }
        path.remove(path.size()-1);
        
    }
}
