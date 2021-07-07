//TC: O(n), as we visit every node exactly once
//SC: 0(n), due to the usage of stack
//Approach: Did inorder traversal for sorting, and returned the kth element

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        int res = 0;
        //List<Integer> list = new ArrayList<>();
        int count=0;
        if(root==null) return 0;
        int i=0;
        while(root!=null||!stack.isEmpty()){
        while(root!=null){
            stack.push(root);
            root=root.left;
        }
        root=stack.pop();
        if(count==k-1) res=root.val;
        System.out.println(root.val);
        //list.add(root.val);
        count++;
        root=root.right;
        }
        
        //return list.get(k-1);
        return res;
    }
}
