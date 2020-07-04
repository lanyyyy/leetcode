package a199_erChaShuBianLi;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class AllKindsBianLi {

    public static void main(String[] args) {
        TreeNode1 treeNode1 = doInit();
        System.out.println("********** 前序遍历 **********");
        qianXu(treeNode1);
        System.out.println();
        System.out.println("********** 中序遍历 **********");
        zhongXu(treeNode1);
        System.out.println();
        System.out.println("********** 后续遍历 **********");
        houXu(treeNode1);
        System.out.println();
        System.out.println("********** 层序遍历 **********");
        cengXu(treeNode1);

    }

    private static void qianXu(TreeNode1 treeNode1) {
        if (treeNode1 == null) {
            return;
        }
        System.out.print(treeNode1.val);
        qianXu(treeNode1.left);
        qianXu(treeNode1.right);
    }

    private static void zhongXu(TreeNode1 treeNode1) {
        if (treeNode1 == null) {
            return;
        }
        zhongXu(treeNode1.left);
        System.out.print(treeNode1.val);
        zhongXu(treeNode1.right);
    }

    private static void houXu(TreeNode1 treeNode1) {
        if (treeNode1 == null) {
            return;
        }
        houXu(treeNode1.left);
        houXu(treeNode1.right);
        System.out.print(treeNode1.val);
    }

    private static void cengXu(TreeNode1 treeNode1) {
        Queue<TreeNode1> queue = new LinkedBlockingQueue<>();
        queue.add(treeNode1);
        while (!queue.isEmpty()) {
            TreeNode1 t = queue.poll();
            if (t == null) {
                continue;
            }
            System.out.print(t.val);
            if (t.left != null) {
                queue.add(t.left);
            }
            if (t.right != null) {
                queue.add(t.right);
            }
        }
    }

    /**
     * 初始化二叉树构造
     *
     * @return TreeNode
     * A
     * /  \
     * B    C
     * /\   /\
     * D E  F G
     * \
     * H
     * 前序：ABDHECFG
     * 中序：DHBEAFCG
     * 后续：HDEBFGCA
     * 层序：ABCDEFGH
     */
    private static TreeNode1 doInit() {
        TreeNode1 treeNode1 = new TreeNode1("A");
        treeNode1.left = new TreeNode1("B");
        treeNode1.right = new TreeNode1("C");
        treeNode1.left.left = new TreeNode1("D");
        treeNode1.left.right = new TreeNode1("E");
        treeNode1.right.left = new TreeNode1("F");
        treeNode1.right.right = new TreeNode1("G");
        treeNode1.left.left.right = new TreeNode1("H");
        return treeNode1;

    }
}

class TreeNode1 {
    String val;
    TreeNode1 left;
    TreeNode1 right;

    TreeNode1(String x) {
        val = x;
    }
}
