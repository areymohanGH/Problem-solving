import java.util.Arrays;

public class LeetcodeProblems {
    public static void main(String[] args) {
        EasyProblems easyProblems = new EasyProblems();
        MediumProblems mediumProblems = new MediumProblems();
        // int[] prices = { 7, 1, 5, 3, 6, 4 };
        // int a = easyProblems.maxProfit(prices);
        // System.out.println(a);
        int a = mediumProblems.maxSubArray(new int[] { -2, -3, -1, -7});
        System.out.println(a);
    }
}