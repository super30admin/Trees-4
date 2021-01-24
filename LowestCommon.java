/** Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
* TC O(N) SC O(H) where H is height of tree
*/
class Solution {
    List<TreeNode> pList;
    List<TreeNode> qList; 
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return root;
        }
        pList = new ArrayList<>();
        qList = new ArrayList<>();
        helper(root, p, pList);
        helper(root, q, qList);
        TreeNode res = null;
        for (int i = 0; i < Math.min(pList.size(), qList.size()); i ++) {
            if (pList.get(i) != qList.get(i)){
                break;
            }
            res = pList.get(i);
        }
        return res;
    }
    private void helper(TreeNode root, TreeNode p, List<TreeNode> list){
        if(root == null){
            return;
        }
        list.add(root);
        if (root == p){
            return;
        }
       
        helper(root.left, p, list);
        helper(root.right, p, list);
        if (list.get(list.size() - 1) != p) {
            list.remove(list.size() -1);
        }
        
    }
}
