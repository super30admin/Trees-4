import java.util.List;
import java.util.ArrayList;

public class LCABinaryTreeBacktracking {


        // Backtracking solution - O(N) time - O(H) space

        private List<TreeNode> pathP;
        private List<TreeNode> pathQ;

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

            dfsBacktrack(root, p, q, new ArrayList<>()); // O(N)

            // compare P and Q paths
            for(int i = 0; i < pathP.size(); i++) {      // O(H)

                if(pathP.get(i) != pathQ.get(i)) {

                    // return Tree Node before the mismatch as that is the last/the lowest common ancestor
                    return pathP.get(i -1);
                }
            }
            return null;
        }

        public void dfsBacktrack(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path){

            //base
            if(root == null) return;

            //logic
            //action
            path.add(root);

            if(root == p) {

                pathP = new ArrayList<>(path);

                //add p again to path if root is p i.e., add p again to p's path
                pathP.add(p);
            }

            if(root == q) {

                pathQ = new ArrayList<>(path);

                //add q again to path if root is q i.e., add q again to q's path
                pathQ.add(q);
            }

            // conditional recursion

            // do recursion until pathP and pathQ are found
            if(pathP == null || pathQ == null) {

                dfsBacktrack(root.left, p, q, path);
                //traverse both left and right subtrees at root
                dfsBacktrack(root.right, p, q, path);
            }

            //backtrack
            path.remove(path.size() - 1);
            //undo last added tree node for path recursion to run freely

        }


}

/*
TIME COMPLEXITY = O(N)

traversing all tree nodes in binary tree potentially = O(N)

SPACE COMPLEXITY = O(H)

recursive stack space = O(H)
*/