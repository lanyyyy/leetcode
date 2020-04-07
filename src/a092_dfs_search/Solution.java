package a092_dfs_search;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode head = new TreeNode(2);
        head.left = new TreeNode(1);
        head.right = new TreeNode(3);
        System.out.println(solution.isValidBST(head));


        TreeNode head1 = new TreeNode(1);
        head1.left = new TreeNode(1);
        head1.right = new TreeNode(4);
        head1.right.left = new TreeNode(3);
        head1.right.right = new TreeNode(6);
        System.out.println(!solution.isValidBST(head1));

        TreeNode head2 = new TreeNode(1);
        head2.left = new TreeNode(2);
        head2.left.left = new TreeNode(3);
        head2.left.left.left = new TreeNode(4);
        head2.left.left.left.left = new TreeNode(5);
        System.out.println(!solution.isValidBST(head2));

        TreeNode head3 = new TreeNode(1);
        head3.right = new TreeNode(2);
        head3.right.right = new TreeNode(3);
        head3.right.right.right = new TreeNode(4);
        head3.right.right.right.right = new TreeNode(5);
        System.out.println(solution.isValidBST(head3));

        System.out.println(solution.isValidBST(new TreeNode(1)));
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return verified(root, root.val, root.val, root.val, root.val);
    }

    /**
     * 关系： min1 < min2 < ... < min3 < min4
     * @param root 节点
     * @param min1 最小
     * @param min2 次最小
     * @param min3 次最大
     * @param min4 最大
     * @return
     */
    private boolean verified(TreeNode root, int min1, int min2, int min3, int min4) {
        boolean isLeft = true;
        boolean isRight = true;

        if (root.left != null) {
            if (root.val <= root.left.val) {
                return false;
            } else if (min1 <= root.left.val) {
                return false;
            }
            isLeft = verified(root.left, root.left.val, root.val, min3, min4);
        }
        if (root.right != null) {
            if (root.val >= root.right.val) {
                return false;
            }
//            else if (min3 )
//            isRight = verified(root.right);
        }
        return isLeft && isRight;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
