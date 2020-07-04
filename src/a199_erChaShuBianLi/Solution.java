package a199_erChaShuBianLi;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Solution {
    public static void main(String[] args) {

    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        Queue<TreeNode> newQueue = new LinkedBlockingQueue<>();
        newQueue.add(root);
        diGui(newQueue);
        return result;
    }

    private static List<Integer> result;

    public void diGui(Queue<TreeNode> queue) {
        if (queue.isEmpty()) {
            return;
        }
        Queue<TreeNode> newQueue = new LinkedBlockingQueue<>();
        TreeNode newTreeNode = queue.peek();
        while (!queue.isEmpty()) {
            newTreeNode = queue.remove();
            if (newTreeNode.left != null) {
                newQueue.add(newTreeNode.left);
            }
            if (newTreeNode.right != null) {
                newQueue.add(newTreeNode.right);
            }
        }
        result.add(newTreeNode.val);
        diGui(newQueue);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
