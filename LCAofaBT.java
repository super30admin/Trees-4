/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 /*
 - Iterative using map and set
 - traverse through each node and add the node and the parent in the map
 - process all ancestors of p node using parent map
 - start processing q, the first ancestor of q which is in ancestor set of p is LCA 

 TC: O(n) -> iterate over all the elements in the tree + O(max(height of p and q)) -> so overall TC:O(n)
 SC: O(n) -> queue, map and set -> max is queue as it will contain at max n/2 elements in worst case
  */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        Queue<TreeNode> qu = new LinkedList<>();
        parent.put(root, null);
        qu.add(root);
        //while loop will keep on running as long as one of them is missing, once we find both it stops
        while(!parent.containsKey(p) || !parent.containsKey(q)){
            int size = qu.size();

            for(int i = 0; i < size; i++){
                TreeNode curr = qu.poll();

                if(curr.left != null){
                    parent.put(curr.left, curr);
                    qu.add(curr.left);
                }
                if(curr.right != null){
                    parent.put(curr.right, curr);
                    qu.add(curr.right);
                }
            }
        }
        // System.out.println(parent.get(q).val);
        HashSet<TreeNode> ancestors = new HashSet<>();

        while(p != null){
            ancestors.add(p);
            p = parent.get(p);
        }
        
        while(!ancestors.contains(q)){
            q = parent.get(q);
        }
        return q;
    }
}
