public class KthSmallestInBSTFollowUp {


        //FOLLOW UP
        //did not run on leetcode - line 46

        int leftCnt = 1;

        public int kthSmallest(TreeNode root, int k) {

            TreeNodeWC rootWC = buildTreeWC(root);

            return kthSmallest(rootWC, k);

        }

        public TreeNodeWC buildTreeWC(TreeNode root) {

            if(root == null) return null;

            TreeNodeWC rootWC = new TreeNodeWC(root.val);

            rootWC.left = buildTreeWC(root.left);

            rootWC.leftCnt = leftCnt++;

            rootWC.right = buildTreeWC(root.right);

            return rootWC;
        }

        public int kthSmallest(TreeNodeWC rootWC, int k) {


            if(rootWC != null && rootWC.leftCnt > k) {

                return kthSmallest(rootWC.left, k);
            }

            else if(rootWC != null && rootWC.leftCnt == k) {

                return rootWC.val;
            }

            else {
                //nullpointer exception on leetcode
                return kthSmallest(rootWC.right, k - rootWC.leftCnt + 1);

            }

        }

        private class TreeNodeWC {

            int val; int leftCnt;

            TreeNodeWC left;
            TreeNodeWC right;

            TreeNodeWC(int x) {

                val = x;

                leftCnt = 0;
            }
        }


}

/*
TIME COMPLEXITY = O(H + k)

SPACE COMPLEXITY = O(N)
*/