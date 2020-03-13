package moni;

import java.util.ArrayList;

/**
 * 找到固定路径的tree
 *
 *           10
 *         / \
 *        5  12
 *       / \
 *      4   7
 */
public class TreeSumRoute {

    public static class Node{
        private int value;
        private Node leftNode;
        private Node rightNode;
        public Node(int value, Node leftNode, Node rightNode){
            this.value = value;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }
    }

    /**
     * 查找等于和值的路径，采用递归调用
     * 每遇到一个节点，将该节点的值放入数组列表中，同时将所需和值减去刚进入列表的值作为新和值
     * 如果下一级没有左右孩子，则说明此节点为叶子节点，如果此时和值恰好为零，打印path；如果不为零，说明此路径不正确，应删除path中不可用节点
     * 如果下一级有左或右孩子，则继续递归调用
     * @param node
     * 当前所要经过的节点
     * @param sum
     * 经过当前节点前的和值
     * @param path
     * 当前的路径
     */
    private void findRoute(Node node, int sum, ArrayList<Integer> path){
        path.add(node.value);
        sum -= node.value;
        if(node.leftNode == null&&node.rightNode == null){
            if(sum == 0){
                printPath(path);
            }
        }else{
            if(node.leftNode!=null){
                findRoute(node.leftNode, sum, path);
            }
            if(node.rightNode!=null){
                findRoute(node.rightNode, sum, path);
            }
        }
        //这里remove掉最后的元素是由于运行到这里说明没有匹配成功，则应去除最后的节点
        path.remove(path.size()-1);
    }

    /**
     * 打印路径上的节点值
     * @param path
     * 走过的节点形成的路径，arraylist类型
     */
    private void printPath(ArrayList<Integer> path) {
        for(int i=0; i<path.size(); i++){
            System.out.print(path.get(i)+" ");
        }
        System.out.println();
    }

    private void getRoute(Node node, int sum){
        ArrayList<Integer> path = new ArrayList<Integer>();
        findRoute(node, sum, path);
    }

    public static void main(String[] args) {
        Node node4 = new Node(4,null,null);
        Node node5 = new Node(7,null,null);
        Node node2 = new Node(5,node4,node5);
        Node node3 = new Node(12,null,null);
        Node node1 = new Node(10,node2,node3);
        TreeSumRoute tsr = new TreeSumRoute();
        tsr.getRoute(node1, 22);
    }

}
