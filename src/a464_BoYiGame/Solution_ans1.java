package a464_BoYiGame;

public class Solution_ans1 {

    public static void main(String[] args) {

        Solution_ans1 solutionAns1 = new Solution_ans1();
        System.out.println(solutionAns1.canIWin(11, 10));
        System.out.println(!solutionAns1.canIWin(11, 12));
    }

    Boolean[] dp=null; //用Boolean比较方便判断是否记忆化

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        //小于最大值先手可以直接拿
        if(desiredTotal<=maxChoosableInteger) return true;
        //前N项和还不够desiredTotal
        if((1+maxChoosableInteger)*(maxChoosableInteger)/2<desiredTotal) return false;
        //20位二进制 1<<21
        dp=new Boolean[1<<21];
        return dfs(maxChoosableInteger,desiredTotal,0);
    }

    public boolean dfs(int max,int total,int state){
        if(total<=0) return false; //前人已经拿完了
        if(dp[state]!=null){
            return dp[state];
        }
        for (int i=max;i>=1;i--) {
            //参数传递的，就不用回溯了，代码变的简洁多了
            if((state>>i&1)==0 && !dfs(max,total-i,state|(1<<i))){
                return dp[state]=true;
            }
        }
        return dp[state]=false;
    }

}
