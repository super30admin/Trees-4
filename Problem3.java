// Time Complexity : (mentioned above each function)
// Space Complexity : (mentioned above each function)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

class Solution {
    TreeNode lca = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        iterative(root, p, q);
        return lca;
    }
    /*
    Time : O(n)
    Space : O(h) where h can be n in the worst casw
    */
    private boolean helper(TreeNode node, TreeNode p, TreeNode q){
        if(node == null){
            return false;
        };

        boolean left = (lca == null) ? helper(node.left, p , q) : false;
        boolean right = (lca == null) ? helper(node.right , p , q) : false;

        if((node.val == p.val|| node.val == q.val) || (left && right)){
            if( (left || right) ){
                lca = node;
                return true;
            }
            return true;
        }
        return (left || right);
    }
    /*
    Time : O(n)
    Space : O(n)
    */
    private void iterative(TreeNode root, TreeNode p, TreeNode q){

        // We will create a map of node to its parent
        // We will traverse it in level order
        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();

        // initializing with root
        parentMap.put(root , null) ; // as roots parent is null
        queue.add(root);

        while( ! (parentMap.containsKey(p) && parentMap.containsKey(q)) ){
            TreeNode node = queue.remove();
            if(node!=null){
            parentMap.put(node.left ,node);
            parentMap.put(node.right ,node);
            queue.add(node.left); // adding both levels
            queue.add(node.right);
            }
        }

        // We will create a set of p's parent' and will search q's parent to find common parent
        TreeNode pNode = p;
        Set<TreeNode> pParentSet = new HashSet<>();
        // We will traverse till root and when root's parent is not found then we will stop
        while(pNode!=null){
            pParentSet.add(pNode);
            pNode = parentMap.get(pNode);
        }
        // Now in the we have p and its parent. We will travese q the same way until we find a common parent, the moment we find the common parent that will be our stop
        TreeNode qNode = q;
        // We will get the parent of q and see if its present in p set, offcourse we will check q as well ,as q might be the parent of p 
        while(!pParentSet.contains(qNode)){
            qNode = parentMap.get(qNode);
        }
        lca = qNode; //qNode will be pointing to the lca

    }
}