package a572_has_sub_tree;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode s = new TreeNode(3);
        s.left = new TreeNode(4);
        s.right = new TreeNode(5);
        s.left.left = new TreeNode(1);
        s.left.right = new TreeNode(2);

        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(1);
        t.right = new TreeNode(2);

        System.out.println(solution.isSubtree(s, t));
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (t == null) return true;
        return myFirst(s, t);
        //return force(s, t);
    }

    /**
     * 方法2：暴力递归 --- 醉了，这个竟然击败了96%的人
     */
    private boolean force(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        return  isSame(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }

    /**
     * 方法1：判断前后续字符串
     * 个人第一次思路：通过前序、后序遍历后，转化为字符串，然后对比字符串是否包含
     * 这个解法有问题，不能解决：比如t为一个点，那就判断不了是不是包含子树
     *
     * 因此，在遍历到叶子节点的时候，注意加上一个NULL值，可有效区分
     */
    private boolean myFirst(TreeNode s, TreeNode t) {
        StringBuilder sq = qianXu(s, null);
        StringBuilder tq = qianXu(t, null);
        //StringBuilder sh = houXu(s, null);
        //StringBuilder th = houXu(t, null);

        if (sq.toString().contains(tq)) {
            return true;
        }

        return false;
    }

    /**
     * 前序遍历
     */
    private StringBuilder qianXu(TreeNode s, StringBuilder stringBuilder) {
        if (stringBuilder == null) {
            stringBuilder = new StringBuilder();
        }
        if (s == null) {
            stringBuilder.append("NULL");
            return stringBuilder;
        }
        stringBuilder.append(",").append(s.val);
        qianXu(s.left, stringBuilder);
        qianXu(s.right, stringBuilder);
        return stringBuilder;
    }

    /**
     *
     */
    private StringBuilder houXu(TreeNode s, StringBuilder stringBuilder) {
        if (stringBuilder == null) {
            stringBuilder = new StringBuilder();
        }
        if (s == null) {
            stringBuilder.append("NULL");
            return stringBuilder;
        }
        houXu(s.left, stringBuilder);
        houXu(s.right, stringBuilder);
        stringBuilder.append(",").append(s.val);
        return stringBuilder;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
