/*
Recursion approach
TC: O(N)
SC: O(N)

1. We utilise the property of BST and inorder traversal. 
2. Keep a count and perform inorder. When count reaches zero, its the kth smallest.

Iterative - DFS - Stack
TC: worst case O(N) (to find largest element) 
SC: Left skewed tree can contain all N elements in stack - O(N), balanced tree - O(H) 

*/
import java.util.*;

public class KthSmallest {
    int res;
    int count;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return -1;
        count = k;
        inorder(root);
        return res;
        
    }
    
    private void inorder(TreeNode node){
        
        if(node == null) return;
        
        inorder(node.left);
        count--;
        if(count == 0){ 
            res = node.val;
            return;
        }
        inorder(node.right);
    }

    public int smallestIterative(TreeNode root, int k){
        int count = 0;
        Stack<TreeNode> stk = new Stack<>();
        
        while(!stk.isEmpty() || root != null){
            while(root != null){
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            count++;
            
            if(count == k){
                return root.val;
            }
            
            root = root.right;
        }
        
        return -1;
    }
    
    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(0);

        KthSmallest smallest = new KthSmallest();
        
        System.out.println(smallest.kthSmallest(root, 4));
        System.out.println(smallest.smallestIterative(root, 1));

    }
}
