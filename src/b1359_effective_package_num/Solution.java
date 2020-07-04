package b1359_effective_package_num;

/**
 * 给你 n 笔订单，每笔订单都需要快递服务。
 * <p>
 * 请你统计所有有效的 收件/配送 序列的数目，确保第 i 个物品的配送服务 delivery(i) 总是在其收件服务 pickup(i) 之后。
 * <p>
 * 由于答案可能很大，请返回答案对 10^9 + 7 取余的结果。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 1
 * 输出：1
 * 解释：只有一种序列 (P1, D1)，物品 1 的配送服务（D1）在物品 1 的收件服务（P1）后。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-all-valid-pickup-and-delivery-options
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countOrders(1) == 1);
        System.out.println(solution.countOrders(2) == 6);
        System.out.println(solution.countOrders(3) == 90);
        System.out.println(solution.countOrders(18));
    }

    public int countOrders(int n) {
        if (n <= 1) {
            return n;
        }
        return doWithMath(n);
    }

    /**
     * 方法1：使用数学算法：
     * 先对P做全排列：  fp = n!
     * 再将D插入P中(从尾部开始插入)： fd = 1 * 3 * ... * (2n-1)
     * 最终综合为：total = fp * fd
     *
     * 优化的逻辑，可以提升100%的效率
     * 这个逻辑是可以优化的，可以合并为： total(i) = total(i-1) * i * (2i-1)
     *
     * @param n
     * @return
     */
    private int doWithMath(int n) {
        long start = 1;
        long total = 1;
        while (start <= n) {
            total = total * start * (2 * start - 1) % 1000000007;
            start++;
        }
        return Integer.parseInt(Long.toString(total));

    }
}
