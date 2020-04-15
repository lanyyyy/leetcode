package learn;

public class Test1 {
    public static void main(String[] args) {

        int[]  cells = new int[]{1,0,0,0,1,1,1,1};
        int state = 0;

        for (int i = 0; i < 8; ++i) {
            if (cells[i] > 0)
                state ^= 1 << i;
        }
        System.out.println("state: " + state);
        System.out.println(Integer.toBinaryString(241));


        int a = 10;
        System.out.println(2^0);
        System.out.println(2^1);
        System.out.println(2^2);
        System.out.println(2^3);
        System.out.println(2^4);
        System.out.println(2^5);
    }
}
